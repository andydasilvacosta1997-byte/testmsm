package com.example.msmautocollector
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private val islands = listOf("Plant","Cold","Air","Water","Earth","Fire Haven","Fire Oasis","Light","Psychic","Faerie","Bone","Ethereal","Ethereal Workshop","Wublin","Amber","Shugabush","Gold","Magical Sanctum","Magical Nexus","Paranormal Carnival","Seasonal Shanty","Celestial","Tribal","Composer","Clubbox","The Colossingum","Mirror Plant","Mirror Cold","Mirror Air","Mirror Water","Mirror Earth","Mirror Fire Haven","Mirror Fire Oasis")
class MainActivity: ComponentActivity() {
 override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState); setContent {
  MaterialTheme {
   var running by remember { mutableStateOf(false) }
   var selected by remember { mutableStateOf(islands.toSet()) }
   LazyColumn(Modifier.fillMaxSize().padding(18.dp), verticalArrangement=Arrangement.spacedBy(10.dp)) {
    item { Text("🎵 MSM Auto Collector", style=MaterialTheme.typography.headlineMedium); Text("Experimental Android prototype") }
    item { Card { Column(Modifier.padding(16.dp), verticalArrangement=Arrangement.spacedBy(8.dp)) {
     Text(CollectorAccessibilityService.status)
     Text("Recognises accessible labels only. It pauses rather than guessing taps.")
     Button(onClick={ running=!running; CollectorAccessibilityService.automationEnabled=running; if(running) startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)) }, modifier=Modifier.fillMaxWidth()) { Text(if(running) "STOP" else "START") }
     OutlinedButton(onClick={startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))}, modifier=Modifier.fillMaxWidth()) { Text("Accessibility settings") }
    } } }
    item { Text("Tasks", style=MaterialTheme.typography.titleLarge) }
    item { Text("🪙 Coins: Collect All   •   🍞 Ready bakery food   •   💎 Mini-Mines   •   💎 Maximum Mines") }
    item { Text("Islands (${selected.size}/${islands.size})", style=MaterialTheme.typography.titleLarge) }
    items(islands) { island -> Row(Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.SpaceBetween) {
     Text(island, Modifier.weight(1f)); Checkbox(island in selected, { v-> selected=if(v) selected+island else selected-island })
    }; HorizontalDivider() }
    item { Text("Not a verified game bot. Actual game controls must be exposed to Android Accessibility and tested on-device.") }
   }
  }
 } }
}
