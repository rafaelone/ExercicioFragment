package rafael.fiap.com.br.fragmentsmultiplastelas.views.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.FrameLayout
import rafael.fiap.com.br.fragmentsmultiplastelas.R
import rafael.fiap.com.br.fragmentsmultiplastelas.R.id.flDetailContainer
import rafael.fiap.com.br.fragmentsmultiplastelas.models.Item
import rafael.fiap.com.br.fragmentsmultiplastelas.views.fragments.DetalheItemFragment
import rafael.fiap.com.br.fragmentsmultiplastelas.views.listeners.OnItemSelectedListener

class ListaItensActivity : FragmentActivity(), OnItemSelectedListener {

    private var telaUnica = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_itens)

        determinePanelLayout()
    }

    private fun determinePanelLayout() {
        val fragmentItemDetail = findViewById<FrameLayout>(R.id.flDetailContainer)
        if(flDetailContainer != null){
            telaUnica = true
        }
    }

    override fun onItemSelected(item: Item?) {
        if (telaUnica) {
// Atualiza o framelayout com o fragment
            val detalheItemFragment = DetalheItemFragment.newInstance(item!!)
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.flDetailContainer, detalheItemFragment)
            ft.commit()
        } else {
//Inicia a Activity de detalhe caso não seja um tablet
            val i = Intent(this, DetalheItemActivity::class.java)
            i.putExtra("item", item)
            startActivity(i)
        }
    }

}
