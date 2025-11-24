# 快速开始指南

## 欢迎使用 Android 深色模式演示项目！

这是一个完整的、可运行的 Android 项目，展示了如何实现深色模式。

## ⚡ 快速开始

### 方法 1: 使用 Android Studio（推荐）

1. **下载项目**
   ```bash
   git clone https://github.com/wawo00/android_darkstyle.git
   cd android_darkstyle
   ```

2. **打开项目**
   - 启动 Android Studio
   - 选择 "Open an existing Android Studio project"
   - 浏览到项目目录并选择

3. **等待同步**
   - Android Studio 会自动下载依赖
   - 首次同步可能需要几分钟时间

4. **运行应用**
   - 连接 Android 设备或启动模拟器
   - 点击运行按钮（绿色三角形）或按 `Shift + F10`

### 方法 2: 使用命令行

```bash
# 确保已安装 JDK 17+
java -version

# 构建项目
./gradlew build

# 安装到设备
./gradlew installDebug

# 如果是 Windows 系统
gradlew.bat build
gradlew.bat installDebug
```

## 📋 系统要求

### 必需
- **JDK**: 17 或更高版本
- **Android SDK**: API 34
- **最小 Android 版本**: Android 7.0 (API 24)
- **目标 Android 版本**: Android 14 (API 34)
- **互联网连接**: 首次构建需要下载依赖

### 推荐
- **Android Studio**: Hedgehog | 2023.1.1 或更新版本
- **Gradle**: 8.5（已包含在项目中）
- **内存**: 至少 8GB RAM
- **存储**: 至少 10GB 可用空间

## 📁 项目结构一览

```
android_darkstyle/
│
├── 📄 README.md                    # 项目说明
├── 📄 PROJECT_SUMMARY.md           # 详细总结
├── 📄 UI_DESIGN.md                 # UI 设计说明
├── 📄 QUICK_START.md              # 本文件
│
├── 📂 app/                         # 应用模块
│   ├── build.gradle.kts           # 应用构建配置
│   └── src/main/
│       ├── AndroidManifest.xml    # 应用清单
│       ├── kotlin/                # Kotlin 源代码
│       │   └── MainActivity.kt    # 主界面
│       └── res/                   # 资源文件
│           ├── layout/            # 布局文件
│           ├── values/            # 浅色主题资源
│           └── values-night/      # 深色主题资源
│
└── 📂 gradle/                      # Gradle 配置
    └── wrapper/                   # Gradle Wrapper
```

## 🎯 核心功能演示

### 1. 切换到浅色模式
```
点击 "浅色模式" 按钮 → 应用立即切换为浅色主题
```

### 2. 切换到深色模式
```
点击 "深色模式" 按钮 → 应用立即切换为深色主题
```

### 3. 跟随系统设置
```
点击 "跟随系统" 按钮 → 应用跟随系统深色模式设置
```

### 4. 持久化存储
```
选择主题 → 关闭应用 → 重新打开 → 主题保持不变
```

## 🔧 故障排除

### 问题 1: Gradle 同步失败

**错误信息**: `Could not resolve com.android.tools.build:gradle:8.1.4`

**解决方案**:
1. 检查互联网连接
2. 在 Android Studio 中: File → Invalidate Caches → Restart
3. 删除 `.gradle` 文件夹并重新同步

### 问题 2: 找不到 JDK

**错误信息**: `JAVA_HOME is not set`

**解决方案**:
```bash
# Linux/Mac
export JAVA_HOME=/path/to/jdk-17
export PATH=$JAVA_HOME/bin:$PATH

# Windows
set JAVA_HOME=C:\Program Files\Java\jdk-17
set PATH=%JAVA_HOME%\bin;%PATH%
```

### 问题 3: 构建速度慢

**解决方案**:
1. 在 `gradle.properties` 中添加：
   ```properties
   org.gradle.daemon=true
   org.gradle.parallel=true
   org.gradle.caching=true
   ```
2. 增加 Gradle 内存：
   ```properties
   org.gradle.jvmargs=-Xmx4096m
   ```

### 问题 4: 无法连接设备

**解决方案**:
1. 检查 USB 调试是否已开启
2. 运行 `adb devices` 查看设备列表
3. 如果没有设备，运行 `adb kill-server` 然后 `adb start-server`

## 📱 测试设备要求

### 物理设备
- Android 7.0 (API 24) 或更高版本
- 开启"开发者选项"
- 开启"USB 调试"

### 模拟器
- 推荐使用 Pixel 4 或更新型号
- 系统镜像: Android 10.0 (API 29) 或更高版本
- 推荐: 带 Google Play 的系统镜像

## 🎨 自定义主题

### 修改颜色

编辑 `app/src/main/res/values/colors.xml`:
```xml
<color name="purple_500">#FF6200EE</color>  <!-- 改为你喜欢的颜色 -->
```

### 添加新主题

1. 在 `values/themes.xml` 中添加新样式
2. 在 `values-night/themes.xml` 中添加对应的深色样式
3. 在 `MainActivity.kt` 中添加切换逻辑

## 📚 学习资源

### 官方文档
- [Android 开发者文档](https://developer.android.com/docs)
- [深色主题指南](https://developer.android.com/guide/topics/ui/look-and-feel/darktheme)
- [ViewBinding 指南](https://developer.android.com/topic/libraries/view-binding)

### 相关主题
- Material Design 3
- Kotlin 协程
- Jetpack Compose（下一代 UI 工具包）
- DataStore（替代 SharedPreferences）

## 🚀 下一步

完成基础功能后，你可以：

1. **添加动画效果**
   - 主题切换过渡动画
   - 按钮点击反馈

2. **扩展主题选项**
   - 添加更多颜色主题
   - 自定义主题选择器

3. **优化用户体验**
   - 添加欢迎引导页
   - 实现主题预览功能

4. **集成更多功能**
   - 字体大小调节
   - 语言切换
   - 数据备份

5. **使用现代技术**
   - 迁移到 Jetpack Compose
   - 使用 DataStore 替代 SharedPreferences
   - 添加单元测试和 UI 测试

## 💡 提示和技巧

### 调试技巧
```kotlin
// 在 MainActivity 中添加日志
import android.util.Log

private val TAG = "MainActivity"

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.d(TAG, "应用启动，当前主题: ${getCurrentTheme()}")
    // ...
}
```

### 性能优化
1. 使用 ViewBinding 而非 findViewById
2. 避免在主线程进行耗时操作
3. 合理使用 SharedPreferences

### 最佳实践
1. 始终使用主题属性（`?attr/colorPrimary`）而非硬编码颜色
2. 为深色和浅色模式提供合适的资源
3. 测试两种模式下的可读性和对比度
4. 遵循 Material Design 指南

## 🤝 获取帮助

如果遇到问题：
1. 查看项目文档（README.md, PROJECT_SUMMARY.md）
2. 检查 Android Studio 的错误日志
3. 搜索 Stack Overflow
4. 查阅 Android 官方文档

## 📄 许可证

本项目仅用于学习和演示目的。

---

**祝你开发愉快！** 🎉

如果这个项目对你有帮助，请给个 ⭐ Star！
