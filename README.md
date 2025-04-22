# Library Version Compare Plugin

## 📖 Overview
The **Library Version Compare Plugin** is an IntelliJ IDEA plugin designed to help developers compare different versions of a library. It provides an intuitive interface to identify differences between two versions of a library, making it easier to track changes and ensure compatibility.

## ✨ Features
- **Compare Library Versions**: Select two versions of a library (e.g., Git tags) and compare their contents.
- **File Difference Scanner**: Detect changes in files between the selected versions.
- **Clear Results**: Quickly clear the comparison results with a single action.
- **Persistent Settings**: Automatically save and reuse repository paths and tags for future comparisons.
- **User-Friendly Interface**: Simple dialogs and lists to display results and manage comparisons.

## 🚀 How It Works
1. **Open the Plugin**: Access the plugin through the IntelliJ IDEA toolbar or menu.
2. **Set Parameters**: Enter the repository path, adapted path, and the tags for the old and new versions.
3. **Run Comparison**: The plugin scans the differences between the selected versions and displays the results.
4. **View Results**: See the list of changed files and their details.
5. **Clear Results**: Use the "Clear" action to reset the list for a new comparison.

## 🛠️ How to Contribute
We welcome contributions to improve the plugin! If you have ideas, suggestions, or bug reports, feel free to:
1. **Open an Issue**: Go to the [Issues](https://github.com/denysrichter4/libraryversioncompare/issues) tab and create a new issue describing your idea or problem.
2. **Submit a Pull Request**: Fork the repository, make your changes, and submit a pull request for review.

## 📬 Feedback
If you encounter any issues or have suggestions for new features, don't hesitate to open an issue. Your feedback is invaluable to us!

---

Thank you for using the **Library Version Compare Plugin**! 😊

# Template
![Build](https://github.com/denysrichter4/Library-Version-Compare/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/MARKETPLACE_ID.svg)](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/MARKETPLACE_ID.svg)](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID)

## Template ToDo list
- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [ ] Get familiar with the [template documentation][template].
- [ ] Adjust the [pluginGroup](./gradle.properties) and [pluginName](./gradle.properties), as well as the [id](./src/main/resources/META-INF/plugin.xml) and [sources package](./src/main/kotlin).
- [ ] Adjust the plugin description in `README` (see [Tips][docs:plugin-description])
- [ ] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html?from=IJPluginTemplate).
- [ ] [Publish a plugin manually](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate) for the first time.
- [ ] Set the `MARKETPLACE_ID` in the above README badges. You can obtain it once the plugin is published to JetBrains Marketplace.
- [ ] Set the [Plugin Signing](https://plugins.jetbrains.com/docs/intellij/plugin-signing.html?from=IJPluginTemplate) related [secrets](https://github.com/JetBrains/intellij-platform-plugin-template#environment-variables).
- [ ] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html?from=IJPluginTemplate).
- [ ] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.

<!-- Plugin description -->
This Fancy IntelliJ Platform Plugin is going to be your implementation of the brilliant ideas that you have.

This specific section is a source for the [plugin.xml](/src/main/resources/META-INF/plugin.xml) file which will be extracted by the [Gradle](/build.gradle.kts) during the build process.

To keep everything working, do not remove `<!-- ... -->` sections.
<!-- Plugin description end -->

## Installation

- Using the IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "Library-Version-Compare"</kbd> >
  <kbd>Install</kbd>

- Using JetBrains Marketplace:

  Go to [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID) and install it by clicking the <kbd>Install to ...</kbd> button in case your IDE is running.

  You can also download the [latest release](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID/versions) from JetBrains Marketplace and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

- Manually:

  Download the [latest release](https://github.com/denysrichter4/Library-Version-Compare/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation