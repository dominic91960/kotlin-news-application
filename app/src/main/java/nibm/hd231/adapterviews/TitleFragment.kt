package nibm.hd231.adapterviews

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class TitleFragment(var selected:String) : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_title, container, false)
        val lvTitles: ListView = view.findViewById(R.id.lvTitles)
        var subjects:Array<String> = arrayOf("x","x","x")

        when(selected) {
            "SPORTS" -> subjects = arrayOf("SPORTS1","SPORTS2","SPORTS3")
            "TECH" -> subjects = arrayOf("TECH1","TECH2","TECH3")
            "ENTERTAINMENT" -> subjects = arrayOf("ENTERTAINMENT1","ENTERTAINMENT2","ENTERTAINMENT3")
        }

        //4.Create adapter
        var listAdapter: ArrayAdapter<String> = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1, //layout used to represent one item
            subjects//data source
        )

        //5.Set adapter for listview
        lvTitles.adapter = listAdapter

        //Handling Item click event for listView
        lvTitles.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var selected:String = subjects[position]

                val fragmentContainer = R.id.articleContainer
                //To manage fragments for the activity
                val fragManager: FragmentManager = childFragmentManager
                //To manage loading and unloading fragments
                val fragTransaction: FragmentTransaction = fragManager.beginTransaction()
                //Create fragment
                val fragment: ContentFragment= ContentFragment(selected)
                //Specify the transaction
                fragTransaction.replace(fragmentContainer, fragment)
                //Commit Transaction
                fragTransaction.commit()
            }

        }
        return view
    }
}