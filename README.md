# MSM Auto Collector — Android prototype
This is source code, not a prebuilt or tested APK. The app includes a dashboard, island checklist, Start/Stop control, and an experimental Accessibility Service that only attempts a clearly labelled `Collect All` button. It does not yet navigate the map or recognise bakeries/mines reliably; if the game does not expose controls to Accessibility, it cannot automate them safely.

## Build an APK using your phone
1. Sign in to GitHub and create a repository.
2. Upload all files in this ZIP to the repository (including `.github/workflows/build-apk.yml`).
3. Open the repository's **Actions** tab and run **Build MSM Auto Collector APK**.
4. When successful, open the workflow run and download the `MSM-Auto-Collector-debug` artifact.
5. Extract the artifact ZIP and install `app-debug.apk`. Android may ask you to allow installs from your browser or file manager.

Enable the service only if you understand Android Accessibility permissions. You can disable it in Android Settings at any time. Never share your game password.
