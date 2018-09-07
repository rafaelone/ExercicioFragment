package rafael.fiap.com.br.fragmentsmultiplastelas.views.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import rafael.fiap.com.br.fragmentsmultiplastelas.R
import rafael.fiap.com.br.fragmentsmultiplastelas.models.Item
import rafael.fiap.com.br.fragmentsmultiplastelas.views.listeners.OnItemSelectedListener

class ListaItensFrament: Fragment(){
    private var adaperIems: ArrayAdapter<Item>? = null
    private var lvlItems: ListView? = null
    private var listener: OnItemSelectedListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        val myActivity: Activity
        if(context is Activity){
            myActivity = context
            if(myActivity is OnItemSelectedListener){
                listener = myActivity
            }else{
                throw ClassCastException(activity.toString() + "must implement ItemsListFragment.OnItemSelectedListene")
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lista_itens, container, false)
        lvlItems = view.findViewById(R.id.lvItens)
        lvlItems?.adapter = adaperIems
        lvlItems?.onItemClickListener = AdapterView.OnItemClickListener { adapterView,
                                                                         item, position, rowId ->
            val i = adaperIems!!.getItem(position)
            listener?.onItemSelected(i)
        }
        return view
    }
}