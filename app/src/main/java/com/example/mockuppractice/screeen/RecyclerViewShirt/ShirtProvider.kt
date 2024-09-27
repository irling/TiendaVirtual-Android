package com.example.mockuppractice.screeen.RecyclerViewShirt

import com.example.mockuppractice.screeen.RecyclerViewBags.Bags
import com.example.mockuppractice.screeen.RecyclerViewShirt.PagesShirt.Shirt01
import com.example.mockuppractice.screeen.RecyclerViewShirt.PagesShirt.Shirt02
import com.example.mockuppractice.screeen.RecyclerViewShirt.PagesShirt.Shirt03
import com.example.mockuppractice.screeen.RecyclerViewShirt.PagesShirt.Shirt04
import com.example.mockuppractice.screeen.RecyclerViewShirt.PagesShirt.Shirt05
import com.example.mockuppractice.screeen.RecyclerViewShirt.PagesShirt.Shirt06

class ShirtProvider {

    companion object {

        val ShirtListFirst = listOf<Shirt>(
            Shirt(
                "https://i.imgur.com/v3eEDb9.jpeg", Shirt01::class.java
            ),
            Shirt(
                "https://i.imgur.com/8pBncLW.jpeg", Shirt02::class.java
            ),
            Shirt(
                "https://i.imgur.com/Hxnsisk.jpeg", Shirt03::class.java
            ),
            Shirt(
                "https://i.imgur.com/Iuaupxe.jpeg", Shirt04::class.java
            ),
            Shirt(
                "https://i.imgur.com/hlJPpXp.jpeg", Shirt05::class.java
            ),
            Shirt(
                "https://i.imgur.com/Ci2mUuC.jpeg", Shirt06::class.java
            )
        )


    }

}