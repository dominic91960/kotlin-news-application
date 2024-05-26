package nibm.hd231.adapterviews

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class ContentFragment(var selected:String) : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_content, container, false)
        val tvContent: TextView = view.findViewById(R.id.tvContent)
        when(selected) {
            "SPORTS1" -> tvContent.text = "Hello SPORTS1"
            "SPORTS2" -> tvContent.text = "Hello SPORTS2"
            "SPORTS3" -> tvContent.text = "Hello SPORTS3"
            else -> tvContent.text = "Hello World"
        }
        return view
    }
}