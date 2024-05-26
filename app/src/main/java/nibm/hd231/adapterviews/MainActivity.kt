package nibm.hd231.adapterviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    //1.Declare ListView Object
    private lateinit var lstSubjects: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //2.Initialize the object
        lstSubjects = findViewById(R.id.lstSubjects)

        //3.Create the collection
        var subjects = arrayOf("SPORTS","TECH","ENTERTAINMENT")

        //4.Create adapter
        var listAdapter:ArrayAdapter<String> = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_list_item_1, //layout used to represent one item
            subjects //data source
        )

        //5.Set adapter for listview
        lstSubjects.adapter = listAdapter

        //Handling Item click event for listView
        lstSubjects.onItemClickListener = object :AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var selected:String = subjects[position]

                val fragmentContainer = R.id.articleTitleContainer
                //To manage fragments for the activity
                val fragManager: FragmentManager = supportFragmentManager
                //To manage loading and unloading fragments
                val fragTransaction: FragmentTransaction = fragManager.beginTransaction()
                //Create fragment
                val fragment: TitleFragment= TitleFragment(selected)
                //Specify the transaction
                fragTransaction.replace(fragmentContainer, fragment)
                //Commit Transaction
                fragTransaction.commit()
            }

        }
    }
}