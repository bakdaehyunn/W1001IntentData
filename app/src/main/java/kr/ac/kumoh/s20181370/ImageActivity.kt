package kr.ac.kumoh.s20181370

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kr.ac.kumoh.s20181370.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity(), View.OnClickListener {
    companion object{
        const val LIKE =10
        const val DISLIKE =20
        const val NONE =0

        const val imageName ="image"
        const val resultName ="result"
    }
    private lateinit var binding: ActivityImageBinding
    private var image: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        image =intent.getStringExtra(MainActivity.keyName)
        val res = when (image){
            "gundam" ->R.drawable.gundam
            "zaku" ->R.drawable.zaku
            else -> R.drawable.ic_launcher_foreground
        }
        binding.imgGundam.setImageResource(res)

        binding.btnLike.setOnClickListener(this)
        binding.btnDislike.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent()
        val value =when (v?.id){
            binding.btnLike.id -> LIKE
            binding.btnDislike.id -> DISLIKE
            else -> NONE
        }
        intent.putExtra(imageName, image)
        intent.putExtra(resultName,value)
        setResult(RESULT_OK,intent)
        finish()
    }
}