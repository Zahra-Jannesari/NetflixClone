package com.zarisa.netflixclone

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zarisa.netflixclone.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var sharedPrefInfo: SharedPreferences? = null
    lateinit var shareBtnState:SharedPreferences
    private var registerState:Boolean?=false
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefInfo = this.activity?.getSharedPreferences("Information", Context.MODE_PRIVATE)
        shareBtnState=this.requireActivity().getSharedPreferences("btnsState",Context.MODE_PRIVATE)
        (activity as AppCompatActivity).supportActionBar?.title = "FILMOLOGY"
        registerState=sharedPrefInfo?.getBoolean(isRegistered,false)

        favBtnsSetStateAndOnClick()
    }


    private fun favBtnsSetStateAndOnClick() {
        val editorBtns = shareBtnState.edit()
        var is11Clicked=shareBtnState.getBoolean("11",false)
        var is12Clicked=shareBtnState.getBoolean("12",false)
        var is13Clicked=shareBtnState.getBoolean("13",false)

        var is21Clicked=shareBtnState.getBoolean("21",false)
        var is22Clicked=shareBtnState.getBoolean("22",false)
        var is23Clicked=shareBtnState.getBoolean("23",false)

        var is31Clicked=shareBtnState.getBoolean("31",false)
        var is32Clicked=shareBtnState.getBoolean("32",false)
        var is33Clicked=shareBtnState.getBoolean("33",false)

        var is41Clicked=shareBtnState.getBoolean("41",false)
        var is42Clicked=shareBtnState.getBoolean("42",false)
        var is43Clicked=shareBtnState.getBoolean("43",false)
        binding.btnFav11.setBackgroundResource(if (is11Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav12.setBackgroundResource(if (is12Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav13.setBackgroundResource(if (is13Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav21.setBackgroundResource(if (is21Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav22.setBackgroundResource(if (is22Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav23.setBackgroundResource(if (is23Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav31.setBackgroundResource(if (is31Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav32.setBackgroundResource(if (is32Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav33.setBackgroundResource(if (is33Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav41.setBackgroundResource(if (is41Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav42.setBackgroundResource(if (is42Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav43.setBackgroundResource(if (is43Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)

        binding.btnFav11.setOnClickListener{
            if (registerState==true) {
                is11Clicked=!is11Clicked
                binding.btnFav11.setBackgroundResource(if (is11Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
                editorBtns.putBoolean("11",is11Clicked)
                editorBtns.apply()
            }
            else notRegisterToast()
        }
        binding.btnFav12.setOnClickListener{
            if (registerState==true) {
                is12Clicked=!is12Clicked
                binding.btnFav12.setBackgroundResource(if (is12Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
                editorBtns.putBoolean("12",is12Clicked)
                editorBtns.apply()
            }
            else notRegisterToast()
        }
        binding.btnFav13.setOnClickListener{
            if (registerState==true) {
                is13Clicked=!is13Clicked
                binding.btnFav13.setBackgroundResource(if (is13Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
                editorBtns.putBoolean("13",is13Clicked)
                editorBtns.apply()
            }
            else notRegisterToast()
        }

        binding.btnFav21.setOnClickListener{
            if (registerState==true) {
                is21Clicked=!is21Clicked
                binding.btnFav21.setBackgroundResource(if (is21Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
                editorBtns.putBoolean("21",is11Clicked)
                editorBtns.apply()
            }
            else notRegisterToast()
        }
        binding.btnFav22.setOnClickListener{
            if (registerState==true) {
                is22Clicked=!is22Clicked
                binding.btnFav22.setBackgroundResource(if (is22Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
                editorBtns.putBoolean("22",is22Clicked)
                editorBtns.apply()
            }
            else notRegisterToast()
        }
        binding.btnFav23.setOnClickListener{
            if (registerState==true) {
                is23Clicked=!is23Clicked
                binding.btnFav23.setBackgroundResource(if (is23Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
                editorBtns.putBoolean("23",is23Clicked)
                editorBtns.apply()
            }
            else notRegisterToast()
        }

        binding.btnFav31.setOnClickListener{
            if (registerState==true) {
                is31Clicked=!is31Clicked
                binding.btnFav31.setBackgroundResource(if (is31Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
                editorBtns.putBoolean("31",is31Clicked)
                editorBtns.apply()
            }
            else notRegisterToast()
        }
        binding.btnFav32.setOnClickListener{
            if (registerState==true) {
                is32Clicked=!is32Clicked
                binding.btnFav32.setBackgroundResource(if (is32Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
                editorBtns.putBoolean("32",is32Clicked)
                editorBtns.apply()
            }
            else notRegisterToast()
        }
        binding.btnFav33.setOnClickListener{
            if (registerState==true) {
                is33Clicked=!is33Clicked
                binding.btnFav33.setBackgroundResource(if (is33Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
                editorBtns.putBoolean("33",is11Clicked)
                editorBtns.apply()
            }
            else notRegisterToast()
        }

        binding.btnFav41.setOnClickListener{
            if (registerState==true) {
                is41Clicked=!is41Clicked
                binding.btnFav41.setBackgroundResource(if (is41Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
                editorBtns.putBoolean("41",is41Clicked)
                editorBtns.apply()
            }
            else notRegisterToast()
        }
        binding.btnFav42.setOnClickListener{
            if (registerState==true) {
                is42Clicked=!is42Clicked
                binding.btnFav42.setBackgroundResource(if (is42Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
                editorBtns.putBoolean("42",is42Clicked)
                editorBtns.apply()
            }
            else notRegisterToast()
        }
        binding.btnFav43.setOnClickListener{
            if (registerState==true) {
                is43Clicked=!is43Clicked
                binding.btnFav43.setBackgroundResource(if (is43Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
                editorBtns.putBoolean("43",is43Clicked)
                editorBtns.apply()
            }
            else notRegisterToast()
        }
    }

    private fun notRegisterToast(){
        Toast.makeText(activity,"You should register first from profile page!",Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.option_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btn_profile-> {
                if (registerState==true)
                    findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
                else
                    findNavController().navigate(R.id.action_homeFragment_to_registerFormFragment)
            }
            R.id.btn_favorite->findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
            R.id.btn_comeSoon->findNavController().navigate(R.id.action_homeFragment_to_comingSoonFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}
