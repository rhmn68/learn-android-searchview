package id.co.coffeecode.learnsearchview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.support.v7.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var arrayHobby = ArrayList<String>()
    internal var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayHobby)
        search_listView.adapter = adapter

        searchView.isActivated = false
        searchView.onActionViewCollapsed()
        searchView.queryHint = "Type your keyword here"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter?.filter?.filter(p0)
                return false
            }

        })
    }

    private fun loadData() {
        arrayHobby.clear()

        val itemArray = resources.getStringArray(R.array.my_hobby)
        arrayHobby.addAll(itemArray)
    }
}
