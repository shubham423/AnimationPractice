package com.example.animationpractice.ui

import android.animation.*
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.animationpractice.R
import com.example.animationpractice.adapters.CardsAdapter
import com.example.animationpractice.databinding.FragmentCardsBinding
import com.example.animationpractice.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_card_detail.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CardsFragment : Fragment() {

    private lateinit var binding: FragmentCardsBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: CardsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        initObservers()
        mainViewModel.getCardsScreenResponse()
    }

    private fun initObservers() {
        mainViewModel.readMyCardsScreenData.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {

                binding.balance.text = "\$"+"${it[0].myCardsScreenResponse.balance.amount}"
                binding.userImage.load(it[0].myCardsScreenResponse.avatar)
                adapter = CardsAdapter(it[0].myCardsScreenResponse.cards){card,binding->


                    val animator = ObjectAnimator.ofFloat(binding.root, View.ROTATION, -180f, 0f)
                    animator.duration = 1000
                    animator.disableViewDuringAnimation(binding.root)

                    val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1f)
                    val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.6f)
                    val animator2 = ObjectAnimator.ofPropertyValuesHolder(binding.root, scaleX, scaleY)
                    binding.root.translationY=10f
                    animator.disableViewDuringAnimation(binding.root)


                    val set = AnimatorSet()
                    set.playTogether(animator, animator2)
                    set.start()


                    Handler().postDelayed({
                        //doSomethingHere()
                        val extra= FragmentNavigatorExtras(binding.root to "card_wide")
                        val bundle = bundleOf("card" to card)
                        findNavController().navigate(R.id.action_cardsFragment_to_cardDetailFragment,bundle,null,extra)
                    }, 1000)


                }
                binding.rvCards.adapter = adapter


            }

        }
    }
    private fun ObjectAnimator.disableViewDuringAnimation(view: View) {

        // This extension method listens for start/end events on an animation and disables
        // the given view for the entirety of that animation.

        addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                view.isClickable = false
            }

            override fun onAnimationEnd(animation: Animator?) {
                view.isClickable = true
            }
        })
    }
}

