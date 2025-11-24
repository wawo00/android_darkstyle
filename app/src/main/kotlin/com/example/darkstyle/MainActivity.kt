package com.example.darkstyle

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.darkstyle.databinding.ActivityMainBinding

/**
 * 主Activity - 展示深色模式切换功能
 * 
 * 功能说明：
 * 1. 支持浅色模式、深色模式、跟随系统三种主题
 * 2. 使用SharedPreferences保存用户的主题选择
 * 3. 使用ViewBinding简化视图绑定
 * 4. 使用AppCompatDelegate进行主题切换
 */
class MainActivity : AppCompatActivity() {

    // ViewBinding实例
    private lateinit var binding: ActivityMainBinding
    
    // SharedPreferences用于保存主题设置
    private lateinit var sharedPreferences: SharedPreferences
    
    // SharedPreferences的key
    companion object {
        private const val PREFS_NAME = "theme_prefs"
        private const val KEY_THEME_MODE = "theme_mode"
        
        // 主题模式常量
        const val THEME_LIGHT = 0
        const val THEME_DARK = 1
        const val THEME_SYSTEM = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // 初始化ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // 初始化SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        
        // 应用已保存的主题设置
        applySavedTheme()
        
        // 更新当前主题显示
        updateCurrentThemeText()
        
        // 设置按钮点击监听器
        setupButtonListeners()
    }

    /**
     * 设置所有按钮的点击监听器
     */
    private fun setupButtonListeners() {
        // 浅色模式按钮
        binding.btnLightMode.setOnClickListener {
            setCustomTheme(THEME_LIGHT)
        }
        
        // 深色模式按钮
        binding.btnDarkMode.setOnClickListener {
            setCustomTheme(THEME_DARK)
        }
        
        // 跟随系统按钮
        binding.btnSystemDefault.setOnClickListener {
            setCustomTheme(THEME_SYSTEM)
        }
    }

    /**
     * 设置主题
     * @param themeMode 主题模式：THEME_LIGHT（浅色）、THEME_DARK（深色）、THEME_SYSTEM（跟随系统）
     */
  fun setCustomTheme(themeMode: Int) {
        // 保存主题设置到SharedPreferences
        sharedPreferences.edit().putInt(KEY_THEME_MODE, themeMode).apply()
        
        // 根据选择的模式设置应用主题
        when (themeMode) {
            THEME_LIGHT -> {
                // 设置为浅色模式
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            THEME_DARK -> {
                // 设置为深色模式
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            THEME_SYSTEM -> {
                // 跟随系统设置
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }
        
        // 更新当前主题显示文本
        updateCurrentThemeText()
    }

    /**
     * 应用已保存的主题设置
     * 在onCreate中调用，恢复用户之前的主题选择
     */
    private fun applySavedTheme() {
        // 从SharedPreferences读取保存的主题模式，默认为跟随系统
        val savedThemeMode = sharedPreferences.getInt(KEY_THEME_MODE, THEME_SYSTEM)
        
        // 应用主题（不需要更新UI，因为在onCreate中会调用updateCurrentThemeText）
        when (savedThemeMode) {
            THEME_LIGHT -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            THEME_DARK -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            THEME_SYSTEM -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }
    }

    /**
     * 更新当前主题的显示文本
     * 根据保存的主题模式更新UI上显示的当前主题
     */
    private fun updateCurrentThemeText() {
        val currentThemeMode = sharedPreferences.getInt(KEY_THEME_MODE, THEME_SYSTEM)
        
        // 根据当前主题模式设置显示文本
        binding.tvCurrentTheme.text = when (currentThemeMode) {
            THEME_LIGHT -> getString(R.string.light_mode)
            THEME_DARK -> getString(R.string.dark_mode)
            THEME_SYSTEM -> getString(R.string.system_default)
            else -> getString(R.string.system_default)
        }
    }
}
