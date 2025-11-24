# Android 深色模式演示

这是一个展示如何在 Android 应用中实现深色模式的完整演示项目。

## 项目配置

本项目使用以下技术栈和版本：

- **Gradle**: 8.5
- **Android Gradle Plugin (AGP)**: 8.1.4
- **编程语言**: Kotlin
- **ViewBinding**: 已启用
- **UI 语言**: 中文
- **注释语言**: 中文

## 功能特点

1. **主题切换**: 支持浅色模式、深色模式和跟随系统三种主题选项
2. **持久化存储**: 使用 SharedPreferences 保存用户的主题选择
3. **ViewBinding**: 使用 ViewBinding 简化视图绑定，提高代码安全性
4. **Material Design**: 使用 Material Design 3 组件，提供现代化的 UI 体验
5. **中文界面**: 所有按钮、文本和注释都使用中文

## 项目结构

```
android_darkstyle/
├── app/
│   ├── build.gradle.kts          # 应用级 Gradle 配置
│   ├── proguard-rules.pro        # ProGuard 规则
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── kotlin/
│           │   └── com/example/darkstyle/
│           │       └── MainActivity.kt    # 主Activity，包含主题切换逻辑
│           └── res/
│               ├── layout/
│               │   └── activity_main.xml  # 主界面布局
│               ├── values/
│               │   ├── colors.xml         # 浅色主题颜色
│               │   ├── strings.xml        # 字符串资源
│               │   └── themes.xml         # 浅色主题定义
│               └── values-night/
│                   ├── colors.xml         # 深色主题颜色
│                   └── themes.xml         # 深色主题定义
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── build.gradle.kts               # 项目级 Gradle 配置
├── settings.gradle.kts            # Gradle 设置
├── gradlew                        # Gradle Wrapper (Unix)
└── gradlew.bat                    # Gradle Wrapper (Windows)
```

## 技术实现说明

### 1. 主题切换机制

项目使用 `AppCompatDelegate.setDefaultNightMode()` 方法来切换主题：

- `MODE_NIGHT_NO`: 强制使用浅色模式
- `MODE_NIGHT_YES`: 强制使用深色模式
- `MODE_NIGHT_FOLLOW_SYSTEM`: 跟随系统设置

### 2. 主题资源

- `res/values/`: 包含浅色主题的颜色、字符串和样式
- `res/values-night/`: 包含深色主题的颜色和样式

当系统切换到深色模式时，Android 会自动使用 `values-night` 目录下的资源。

### 3. ViewBinding 使用

在 `app/build.gradle.kts` 中启用 ViewBinding：

```kotlin
buildFeatures {
    viewBinding = true
}
```

在 MainActivity 中使用：

```kotlin
private lateinit var binding: ActivityMainBinding

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
}
```

### 4. 持久化存储

使用 SharedPreferences 保存用户的主题选择：

```kotlin
private lateinit var sharedPreferences: SharedPreferences

sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
sharedPreferences.edit().putInt(KEY_THEME_MODE, themeMode).apply()
```

## 构建和运行

### 前提条件

1. **JDK**: 需要 JDK 17 或更高版本
2. **Android SDK**: 需要安装 Android SDK API 34
3. **网络连接**: 首次构建需要下载依赖

### 构建项目

```bash
# 在项目根目录执行
./gradlew build
```

### 运行项目

1. 使用 Android Studio 打开项目
2. 连接 Android 设备或启动模拟器
3. 点击运行按钮或使用快捷键 Shift + F10

或者使用命令行：

```bash
./gradlew installDebug
```

## 主要代码文件说明

### MainActivity.kt

主Activity 包含以下核心功能：

1. **初始化 ViewBinding**: 使用 `ActivityMainBinding.inflate()` 初始化视图
2. **设置按钮监听器**: 为三个主题切换按钮设置点击事件
3. **主题切换逻辑**: 根据用户选择更新应用主题
4. **持久化存储**: 保存和恢复用户的主题选择
5. **UI 更新**: 实时更新界面显示当前使用的主题

### activity_main.xml

主界面布局包含：

1. **MaterialToolbar**: 顶部工具栏
2. **ScrollView**: 可滚动内容区域
3. **MaterialCardView**: 主题信息卡片
4. **MaterialButton**: 三个主题切换按钮（浅色、深色、跟随系统）
5. **功能特点展示区域**: 展示应用的主要功能

### themes.xml

定义了应用的主题样式：

- `Base.Theme.DarkStyle`: 基础主题，继承自 Material Design 3
- 浅色主题使用 `Theme.Material3.Light.NoActionBar`
- 深色主题使用 `Theme.Material3.Dark.NoActionBar`

## 深色模式最佳实践

1. **使用主题属性**: 使用 `?attr/colorPrimary` 等主题属性而非硬编码颜色
2. **提供 values-night 资源**: 为深色模式提供专门的资源文件
3. **测试两种模式**: 确保在浅色和深色模式下都能正常显示
4. **避免纯黑背景**: 深色模式推荐使用 `#121212` 而非纯黑 `#000000`
5. **保持对比度**: 确保文本和背景之间有足够的对比度

## 许可证

本项目仅用于学习和演示目的。

## 作者

Android 开发者

---

**注意**: 本项目需要互联网连接以下载 Android Gradle Plugin 和其他依赖项。首次构建时，Gradle 会自动从 Google Maven 和 Maven Central 下载所需的依赖。
