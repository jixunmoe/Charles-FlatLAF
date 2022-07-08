# Restyle Charles

[中文说明](#中文说明)

Modernise Charles with a refreshing Flat look-and-feel!

You only need this Java Agent loader for Windows.
See [my blog post about Restyling Charles][blog_post] for details.

### Installation

1. Install a full copy of JDK 11, for instance [Adoptium JDK 11][a_jdk11]. Embedded JDK is missing some modules.
2. Remember the path you've installed to. The default should be:  
   `C:\Program Files\Eclipse Adoptium\jdk-11.0.15.10-hotspot\`
3. Download the latest release of [CharlesFlatLAF][charles_flaf_rel] or [compile your own][charles_flaf_git], place it under `<Charles>/lib`;
4. Update `Charles.ini`:
   * Make a backup.
   * Insert the following line after `classpath.1`:  
     `classpath.2=lib/charles_flatlaf-1.0-SNAPSHOT-jar-with-dependencies.jar`
   * Replace the line with `main.class` to:  
     `main.class=uk.jixun.charles.theme.Main`
   * Insert the following line after `vmarg.4`:  
     `vmarg.5=-javaagent=lib/charles_flatlaf-1.0-SNAPSHOT-jar-with-dependencies.jar`
   * Replace the line with `vm.location` to:  
     `vm.location=<JDK path>\bin\server\jvm.dll`

## 中文说明

给 Charles 套上一套全新的扁平化主题，重获新生！

注意：目前只有 Windows 系统需要使用 Java Agent 的方式来防止软件修改回系统默认的主题。
参见[我在博客上发表的在 Charles 应用该主题][blog_post]的说明。

### 安装

1. 下载一份完整版的 JDK，例如 [Adoptium JDK 11][a_jdk11]。这是因为 Charles 自带的 JDK 缺了点东西…
2. 记住他的路径，默认应该是  
   `C:\Program Files\Eclipse Adoptium\jdk-11.0.15.10-hotspot\`
3. 下载最新的 [CharlesFlatLAF][charles_flaf_rel] 或[自己编译一份][charles_flaf_git]，放入 `Charles.jar` 所在的目录，即 `Charles` 安装目录下的 `lib` 目录；
4. 修改配置文件 `Charles.ini`：
   * 首先备份一份该文件，若是改坏了至少还能还原；
   * 在 `classpath.1`下方添加一行：  
     `classpath.2=lib/charles_flatlaf-1.0-SNAPSHOT-jar-with-dependencies.jar`
   * 将 `main.class` 行替换为：  
     `main.class=uk.jixun.charles.theme.Main`
   * 在 `vmarg.4` 下方添加一行：  
     `vmarg.5=-javaagent=lib/charles_flatlaf-1.0-SNAPSHOT-jar-with-dependencies.jar`
   * 将 `vm.location` 行替换为：  
     `vm.location=<JDK 安装目录>\bin\server\jvm.dll`

[charles_flaf_rel]: https://github.com/jixunmoe/Charles-FlatLAF/release
[charles_flaf_git]: https://github.com/jixunmoe/Charles-FlatLAF
[blog_post]: https://jixun.uk/posts/2022/restyle-charles-using-flatlaf/
[a_jdk11]: https://adoptium.net/temurin/releases/?version=11
