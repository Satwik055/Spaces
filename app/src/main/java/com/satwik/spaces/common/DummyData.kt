package com.satwik.spaces.common

import com.satwik.spaces.R
import com.satwik.spaces.domain.model.Property

object DummyData {


    fun getDummyListing():ArrayList<Property>{

        val list = ArrayList<Property>()

        val listing1 = Property("Cleo Heights","New York", arrayListOf("https://officedesigner.com/wp-content/uploads/2023/03/office-designer-london.jpeg"))
        val listing2 = Property("Cleo Heights","New York", arrayListOf("https://officedesigner.com/wp-content/uploads/2023/03/office-designer-london.jpeg"))
        val listing3 = Property("Cleo Heights","New York", arrayListOf("https://officedesigner.com/wp-content/uploads/2023/03/office-designer-london.jpeg"))
        val listing4 = Property("Cleo Heights","New York", arrayListOf("https://officedesigner.com/wp-content/uploads/2023/03/office-designer-london.jpeg"))
        val listing5 = Property("Cleo Heights","New York", arrayListOf("https://officedesigner.com/wp-content/uploads/2023/03/office-designer-london.jpeg"))

        list.add(listing1)
        list.add(listing2)
        list.add(listing3)
        list.add(listing4)
        list.add(listing5)

        return list
    }


}