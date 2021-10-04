package com.example.atividadeprofheltaitemalivrecalculadora

//Importações
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Botão de limpar área dos calculos
        btnLimpar.setOnClickListener{
            entrada.text = ""
            saida.text = ""
        }

        //Dados numéricos
        b0.setOnClickListener{
            entrada.text = AdicionarDadosNaEntrada("0")
        }
        b1.setOnClickListener{
            entrada.text = AdicionarDadosNaEntrada("1")
        }
        b2.setOnClickListener{
            entrada.text = AdicionarDadosNaEntrada("2")
        }
        b3.setOnClickListener{
            entrada.text = AdicionarDadosNaEntrada("3")
        }
        b4.setOnClickListener{
            entrada.text = AdicionarDadosNaEntrada("4")
        }
        b5.setOnClickListener{
            entrada.text = AdicionarDadosNaEntrada("5")
        }
        b6.setOnClickListener{
            entrada.text = AdicionarDadosNaEntrada("6")
        }
        b7.setOnClickListener{
            entrada.text = AdicionarDadosNaEntrada("7")
        }
        b8.setOnClickListener{
            entrada.text = AdicionarDadosNaEntrada("8")
        }
        b9.setOnClickListener{
            entrada.text = AdicionarDadosNaEntrada("9")
        }

        //Dados numéricos - variação
        ponto.setOnClickListener{
            entrada.text = AdicionarDadosNaEntrada(".")
        }

        resultado.setOnClickListener{
            mostrarResultado()
        }

        //Operadores aritméticos
        btnChave_aberta.setOnClickListener{
            entrada.text = AdicionarDadosNaEntrada("(")
        }

        btnChave_fechada.setOnClickListener{
            entrada.text = AdicionarDadosNaEntrada(")")
        }

        btnDividir.setOnClickListener{
            entrada.text = AdicionarDadosNaEntrada("/")
        }

        btnMultiplicar.setOnClickListener{
            entrada.text = AdicionarDadosNaEntrada("x")
        }

        btnSomar.setOnClickListener{
            entrada.text = AdicionarDadosNaEntrada("+")
        }

        btnSubtrair.setOnClickListener{
            entrada.text = AdicionarDadosNaEntrada("-")
        }
    }
    //Função para entrada de dados
    private fun AdicionarDadosNaEntrada(buttonValue: String): String {
        return "${entrada.text}$buttonValue"
    }
    //Converter expressões
    private fun entradaExpressao(): String{
        var expressao = entrada.text.replace(Regex(pattern = "x"), replacement = "*")
        return expressao
    }
    //Função para saída de dados
    private fun mostrarResultado(){
        try {
            val expresssao = entradaExpressao()
            val rst = Expression(expresssao).calculate()
            if (rst.isNaN()){
                saida.text = "Erro de sintaxe!"
                saida.setTextColor(ContextCompat.getColor(this, R.color.ECr))
            }else{
                saida.text = DecimalFormat("0.######").format(rst).toString()
                saida.setTextColor(ContextCompat.getColor(this, R.color.ECg))
            }
        }catch (e: Exception){

        }
    }
}