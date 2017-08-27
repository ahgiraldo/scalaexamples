import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{ Success, Failure }

object TestRestScalaIO {

  def main(args: Array[String]) {
    val url = "http://demo6915862.mockable.io/"
    val resp = scala.io.Source.fromURL(url).mkString
    println(resp)

    val future = Future {
       "concatenare este texto a mi respuesta del servcio Rest " + resp 
      }
    future onComplete {
      case Success(respuesta) => println(respuesta)
      case Failure(respuesta) => println("An error has occured: " + respuesta.getMessage)
    }

    println("esperemos el futuro")
  }

}