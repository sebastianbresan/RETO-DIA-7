
abstract class Usuario (tipo: String){
}
case class Invitado (name: String) extends Usuario("Invitados") {
}
case class Estudiante (user: String, password: String) extends Usuario ("Estudiantes") {
}
case class Administrador(Nivel: Int, name: String) extends Usuario ("Administradores"){
}

object Main {
  def main(args: Array[String]): Unit = {
    val invitado1 = Invitado("Carlos")
    val invitado2 = Invitado("Ramiro")
    val invitado3 = Invitado("Ricardo")
    val listaInvitados: List[Invitado] = List(invitado1, invitado2, invitado3)


    val estudiante1 = Estudiante("user1", "1234")
    val estudiante2 = Estudiante("user2", "1234")
    val estudiante3 = Estudiante("user3", "1234")
    val listaEstudiantes: List[Estudiante] = List(estudiante1, estudiante2, estudiante3)


    val administrador1 = Administrador(1, "Juan")
    val administrador2 = Administrador(2, "Jose")
    val administrador3 = Administrador(1, "Sergio")
    val listaAdministradores: List[Administrador] = List(administrador1, administrador2, administrador3)

    def invitados(): Unit = {
      for (x <- listaInvitados) {
        println(s"${x.name}, No estás autorizado a entrar en esta lección")
      }
      println()
    }

    def administradores(): Unit = {
      for (x <- listaAdministradores) {
        x match {
          case Administrador(1, _) => println(s"${x.name}, Tu nivel es 1 y es insuficiente")
          case Administrador(2, _) => println(s"${x.name}, Tu nivel es 2 y es correcto")
        }
      }
      println()
    }

    def estudiantes(): Unit = {
      for (x <- listaEstudiantes) {
        x match {
          case Estudiante("user2", "1234") => println(s"Bienvenid@ a OpenVitae, ${x.user}")
          case _ =>
        }
      }
    }
    invitados()
    administradores()
    estudiantes()
    }
}
