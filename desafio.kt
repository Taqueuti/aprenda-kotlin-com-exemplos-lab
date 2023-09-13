enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, var duracao: Int)

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} foi matriculado na formação $nome")
        println()
    }
}

fun main() {
    // Criar instâncias de ConteudoEducacional
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 60)
    val conteudo2 = ConteudoEducacional("Estruturas de Controle em Kotlin", 120)
    val conteudo3 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin", 80)

    // Criar uma formação
    val formacaoKotlin = Formacao("Formação em Kotlin", mutableListOf())

    // Adicionar conteúdos à formação
    formacaoKotlin.conteudos.add(conteudo1)
    formacaoKotlin.conteudos.add(conteudo2)
    formacaoKotlin.conteudos.add(conteudo3)
    
    // Adicionar Alunos inscritos
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")
    
     
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    //Imprimir
    println("Nome da formação: ${formacaoKotlin.nome}")
    println("Conteúdos da formação:")
    formacaoKotlin.conteudos.forEachIndexed { index, conteudo ->
        println("${index + 1}. ${conteudo.nome} (Duração: ${conteudo.duracao} minutos)")
    }
}
