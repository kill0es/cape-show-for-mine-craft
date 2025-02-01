# CapeShow Mod

## 概要

**CapeShow** 是一个 Minecraft 模组，专注于披风的管理与动画化。它允许玩家记录他们使用过的披风，并通过简单的命令来查看、更新这些披风数据，还可以设置动画效果以展示不同披风。

## 主要功能

- **披风记录**：自动记录玩家当前和历史上使用过的所有披风，优化存储只保存披风的哈希值。
- **命令系统**：
  - `/capeshow manage add <player> <capeHash>` - 添加一个新的披风到指定玩家的记录中。
  - `/capeshow manage list <player>` - 列出指定玩家当前记录的所有披风。
  - `/capeshow manage animate <player>` - 为指定玩家启用或调整披风动画效果。
- **动画设置**：
  - 默认规则下，如果玩家拥有两个或两个以上披风，自动启用披风变化动画。
  - 动画默认设置为每秒更换一次披风，但可以通过配置文件自定义动画规则。
- **数据持久化**：披风数据存储在 `cape_database.json` 文件中，确保数据在服务器重启后依然存在。

## 安装

1. **确保你有 Fabric Loader**：
   - 下载并安装与 Minecraft 版本兼容的 Fabric Loader。

2. **安装模组**：
   - 将 `cape_show-1.0.0.jar` 文件放入你的 Minecraft 安装目录的 `mods` 文件夹中。

3. **启动 Minecraft**：
   - 通过 Fabric Loader 启动游戏，确保模组已被加载。

## 使用

- **添加披风**：
  - 使用命令 `/capeshow manage add [玩家名] [披风哈希]` 来记录一个披风。

- **查看披风**：
  - 使用命令 `/capeshow manage list [玩家名]` 查看某玩家所有的披风。

- **设置动画**：
  - 使用命令 `/capeshow manage animate [玩家名]` 来设置或取消披风动画。

## 配置

- **配置文件**：`capeshow_animation.json` 文件位于 `config` 文件夹中，允许玩家或管理员自定义动画设置，如动画间隔时间。

## 技术细节

- **支持版本**：Minecraft 1.21.4（或最新版本）
- **依赖**：Fabric Loader, Fabric API
- **数据结构**：使用 JSON 文件作为简单的数据库，存储玩家披风信息。

## 开发

- **源代码**：[https://github.com/kill0es/cape-show-for-mine-craft]
- **构建**：使用 Gradle Wrapper，运行 `./gradlew build` (Linux/Mac) 或 `gradlew.bat build` (Windows) 来编译模组。

## 贡献

我们欢迎任何形式的贡献，包括但不限于代码、错误修复、文档编写或翻译。如果你有任何改善建议或发现了问题，请在我们的 GitHub 项目中开 issue 或提交 pull request。

## 许可证

CapeShow Mod 遵循 [MIT License](假设链接)。

## 联系

- **邮件**：[quansen.88.com]
- **Discord**：[你的 Discord 服务器]

通过 CapeShow Mod，展示你的个性化披风吧！
```​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​
