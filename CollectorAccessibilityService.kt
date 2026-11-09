package com.example.msmautocollector
import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.util.Log

class CollectorAccessibilityService: AccessibilityService() {
 companion object {
  @Volatile var automationEnabled=false
  @Volatile var status="Idle — enable Accessibility, then press Start"
 }
 private var lastAction=0L
 override fun onAccessibilityEvent(event: AccessibilityEvent?) {
  if(!automationEnabled || event==null) return
  val root=rootInActiveWindow ?: return
  try {
   val nodes=mutableListOf<AccessibilityNodeInfo>()
   fun walk(n:AccessibilityNodeInfo?) { if(n==null)return; nodes.add(n); for(i in 0 until n.childCount) walk(n.getChild(i)) }
   walk(root)
   val target=nodes.firstOrNull { n ->
    val label=((n.text ?: n.contentDescription)?.toString() ?: "").trim()
    n.isEnabled && n.isClickable && label.equals("Collect All",true)
   }
   if(target!=null && System.currentTimeMillis()-lastAction>1200) {
    if(target.performAction(AccessibilityNodeInfo.ACTION_CLICK)) status="Tapped accessible Collect All control"
    else status="Collect All found but not clickable"
    lastAction=System.currentTimeMillis()
   } else status="Watching screen — no labelled Collect All control found"
  } finally { root.recycle() }
 }
 override fun onInterrupt() { automationEnabled=false; status="Paused by Android" }
}
