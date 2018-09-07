package rafael.fiap.com.br.fragmentsmultiplastelas.views.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import rafael.fiap.com.br.fragmentsmultiplastelas.R
import rafael.fiap.com.br.fragmentsmultiplastelas.models.Item
import rafael.fiap.com.br.fragmentsmultiplastelas.views.fragments.DetalheItemFragment

class DetalheItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_item)

        val item = intent.getSerializableExtra("item") as Item

        if(savedInstanceState == null){
            var detalheItemFragment = DetalheItemFragment.newInstance(item)
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.flDetailContainer, detalheItemFragment)
            ft.commit()
        }

    }
}
