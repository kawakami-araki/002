class Hello(name: String){
  def printInfo(): Unit = {
    println(name + " " + Hello.time)
  }
}

object Hello {
  val time = "100"
  def main(args: Array[String]): Unit = {
//    println("Hello World")
    val hc = new Hello(name="小明")
    hc.printInfo()
    val hc1 = new Hello(name="小宏")
    hc1.printInfo()
  }
}