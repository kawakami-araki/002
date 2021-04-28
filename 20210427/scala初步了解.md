---
title: Scala语言基础 ( 一 )
data: 2021/04/27
---







##  Scala语言学习笔记 - 其一



#### ps: 由于工作上的需要, 不得不来学习Java以及Scala语言的使用, 思来想去, 顺手做个笔记留个印象, 免得回头自己忘记了

#### ps: 环境配置不做过多赘述, 自行百度即可

1. 构建第一个Scala程序

   - ```scala
     object HelloWorld {
         def main(args: Array[String]): Unit = {
             println("Hello World!")
         }
     }
     ```

   - 构建基础的object对象, 该对象在之后的编译中会生成对应名称的class文件

   - 对象中直接使用def来定义一个函数, 函数参数书写方式与java不同, 整体结构为:   <参数名称 :  参数类型定义( 如示例中的Array[String], 意为元素为字符串形式的数组)>

   - 定义完参数之后, 需要定义返回值, 示例中没有准备返回值, 因此使用Unit表示

   - 返回值定义之后为函数运行时进行的工作, 如示例所示的输出"helloworld"

2. 进行编译与使用

   - ```she
     scalac HelloWorld.scala
     
     // 使用scalac来对写好的scala文件进行编译处理
     ```

   - ```shel
     scala HelloWorld
     
     // 使用scala来运行编译好的HelloWorld.class文件
     ```

-----

### Scala使用IDEA进行编辑

1. 下载IDEA安装包进行安装
   - 官方地址: [IDEA DOWNLOAD]([Download IntelliJ IDEA: The Capable & Ergonomic Java IDE by JetBrains](https://www.jetbrains.com/idea/download/))
2. 配置对应的环境
   - 安装IDEA之后, 需要对软件内部环境进行设置, 具体包括下载Scala插件, 配置Java JDK, 配置Scala SDK等
3. 创建新的项目
   - 这里创建项目我们可以选择创建一个Maven项目, 或者直接创建一个JAVA项目, 并选择Scala(如果你没有下载对应的Scala插件的话,这里将不会显示该选项, 可以直接创建Maven项目然后进行后续配置, 同样可以使用)
4. 如果你是直接创建的Scala项目, 可以略过这一条
   - 当创建好Maven项目之后, 我们还需要在项目的src/main下创建一个用来引用的Scala文件夹, 并将其Mark Directory as Test Sources Boot
   - 这个时候, 我们依然无法使用Scala, 还需要对整个项目进行操作, 添加其支持的框架, 然后在弹出的窗口中选中Scala
     - 这个时候容易出现的问题是提示没有Scala SDK, 可以直接使用后面的Create按钮, 然后直接download一个新的SDK, 然后进行选中
   - 完成这一步之后, 我们就可以在项目中直接创建Scala Class了

### Scala 类使用

1. scala能够构建伴生类, 如 class对象的半身类为object对象, 两个对象的名称完全相同, 并且这两个类能够互相调用对方的私有属性. 也就是说, 我们可以通过在object对象中构建常量类型的私有属性, 然后再class类中进行调用, 并最终通过object对象的main函数来进行使用
2. 在编译后的运行中, 程序会调用main函数, 然后运行main函数代码, 通过在main函数中new一个新的class类对象的方式, 来获得条包含有object对象私有属性,以及new一个新对象时传入的参数组成的数据

### Scala格式化输入

1. 普通的+与*

   - 和其他的编程语言大体相同, +的作用依然是拼接两个字符串来进行输出, * 的作用则是复制对应数量的字符串并进行拼接输出

2. printf

   - 使用该方法, 可以使代码更加简洁, 不需要进行重复的+法拼接, 而是通过%d, %s的形式来将变量添加到写好的语句中去

   - ```scala
     printf("This is a %s String", "test")
     printf("my age is %d", 18)
     ```

   - 如上述情况一般

3. s""

   - 这种写法相较于pringf更加简洁, 具体使用方法为通过${}中添加变量名的方式来完成格式化输入, 整体看起来比较美观

   - ```scala
     var a = "test"
     pringln(s"This is a ${a} demo")
     ```

   - 相比较前两种更加的简洁

4. f""

   - 格式化模板字符串(浮点数专用)

   - ```scala
     var b : Float = 2.265f
     println(f"This number is ${b}%2.2f")
     ```

   - 在scala中, 默认的浮点数类型是Double, 如果想要定义数据类型为float的话, 则需要在小数后面添加一个f, 来表示这个浮点数的类型为Float

   - 在句子中使用%2.2f的时候,  .前面的数字表示这个浮点数至少要有2位,如果不够的话,将会自动使用空格来补齐

   - .后面的数字表示这个浮点数的精度需要精确到小数点后几位, f则表示该数据类型为float

5. raw""

   - 格式化模板字符串, 意为将模板字符串按照原始的样子进行输出

   - ```scala
     println(raw"This number is ${b}%2.2f")
     ```

   - 使用raw之后, 将会忽略后续的数据处理, 如上所示, 将不会再对这个小数进行处理, 而是将后面的%2.2f当作正常的字符串来进行输出
6. 三引号
   - 使用""""""来进行需要多行的字符串并能够进行格式化输出
   - ```scala
     println(
      s"""
         |select * from student
         |where
         |  age > 18
         |;
         |""".stripMargin)
     ```
   -  striptMargin是为了让这个字符串忽略边界的空格, 来保证输出的字符串的形态和我们设定的一样, | 左边的空格将会被忽略, 同时, 在这里面可以使用s的格式化输入, 使用方式和基础使用方式一样

   

