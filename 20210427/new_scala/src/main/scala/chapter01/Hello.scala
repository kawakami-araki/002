package chapter01

class Hello(name: String){
  def printInfo(): Unit = {
    println(name + " " + Hello.time)
  }
}

object Hello {
  val time = "100"
  def main(): Unit = {
//    println("Hello World")
    val hc = new Hello(name="小明")
    hc.printInfo()
  }
}