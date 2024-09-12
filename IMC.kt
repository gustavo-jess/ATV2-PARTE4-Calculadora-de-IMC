package br.unipar.atividade05

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alturaEditText = findViewById<EditText>(R.id.heightEditText)
        val pesoEditText = findViewById<EditText>(R.id.weightEditText)
        val calcularButton = findViewById<Button>(R.id.calculateButton)
        val resultadoTextView = findViewById<TextView>(R.id.resultTextView)

        calcularButton.setOnClickListener {
            val alturaTexto = alturaEditText.text.toString()
            val pesoTexto = pesoEditText.text.toString()

            if (alturaTexto.isNotEmpty() && pesoTexto.isNotEmpty()) {
                val altura = alturaTexto.toDoubleOrNull()
                val peso = pesoTexto.toDoubleOrNull()

                if (altura != null && peso != null) {
                    val imc = peso / (altura * altura)
                    val categoria = when {
                        imc < 18.5 -> "Abaixo do peso"
                        imc in 18.5..24.9 -> "Peso normal"
                        imc in 25.0..29.9 -> "Sobrepeso"
                        else -> "Obesidade"
                    }
                    resultadoTextView.text = "IMC: %.2f\nCategoria: $categoria".format(imc)
                } else {
                    resultadoTextView.text = "Insira valores válidos, por favor."
                }
            } else {
                resultadoTextView.text = "Preencha todos os campos, por favor."
            }
        }
    }
}



<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/heightEditText"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Altura (em metros)"
        android:inputType="numberDecimal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toTopOf="@+id/weightEditText"
        android:layout_marginTop="16dp"/>

    <EditText
        android:id="@+id/weightEditText"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Peso (em kg)"
        android:inputType="numberDecimal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/heightEditText"
        app:layout_constraintBottom_toTopOf="@+id/calculateButton"
        android:layout_marginTop="16dp"/>

    <Button
        android:id="@+id/calculateButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Calcular IMC"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/weightEditText"
        app:layout_constraintBottom_toTopOf="@+id/resultTextView"
        android:layout_marginTop="16dp"/>

    <TextView
        android:id="@+id/resultTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Resultado aparecerá aqui"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/calculateButton"
        android:layout_marginTop="16dp"/>

</androidx.constraintlayout.widget.ConstraintLayout>
