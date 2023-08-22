enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int)

class Formacao(val nome: String, val nivel: Nivel, vararg conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        
        if (inscritos.contains(usuario)) {
            throw Error("Usuário já exite.")
        }
        
        inscritos.add(usuario)
    }
    
    fun alunosMatriculados() {
        if (inscritos.isEmpty()) {
            throw Error("Não há usuários cadastrados ainda.")
        }
        
        for (aluno in inscritos) {
        	println(aluno.nome)
        }
    }
 
}

fun main() {
    // Usuarios
    
    val userJorge = Usuario("Jorge", "jorge@hotmail.com")
    val userClaudia = Usuario("Claudia", "claudia@hotmail.com")
    val userLisangela = Usuario("Lisangela", "lisangela@hotmail.com")
    
    // Conteúdos
    
    val conteudo1 = ConteudoEducacional("Pratica com kotlin", 30)
    val conteudo2 = ConteudoEducacional("Coleções", 120)
    val conteudo3 = ConteudoEducacional("Variáveis e tipos", 100)
    val conteudo4 = ConteudoEducacional("Funções", 200)
    
    // Formação
    val kotlinCourse = Formacao(
        nome = "Koltin", 
        nivel = Nivel.INTERMEDIARIO, 
        listOf(conteudo1, conteudo2, conteudo3, conteudo4)
    )
    
    // Add usuários
    

    kotlinCourse.matricular(userJorge)
    kotlinCourse.matricular(userClaudia)
    kotlinCourse.matricular(userLisangela)
   
   
   	kotlinCourse.alunosMatriculados()
    
}
