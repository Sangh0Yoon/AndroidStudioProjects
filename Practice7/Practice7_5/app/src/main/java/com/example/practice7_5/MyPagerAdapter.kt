import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice7_5.databinding.ItemPagerBinding

class MyPagerViewHolder(val binding: ItemPagerBinding) : RecyclerView.ViewHolder(binding.root)

class MyPagerAdapter(val s: MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyPagerViewHolder(ItemPagerBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyPagerViewHolder).binding

        binding.itemPagerTextView.text = datas
    }
    override fun getItemCount(): Int {
        return 4;
    }
}