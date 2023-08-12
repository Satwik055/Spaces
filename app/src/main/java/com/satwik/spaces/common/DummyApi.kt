package com.satwik.spaces.common

import com.satwik.spaces.properties.domain.model.Property

object DummyApi {

    private val listing1 = Property(
        "1",
        "Cleo Heights",
        "New York",
        "This is description, the property poster is supposed to write something here and fill this nigga up",
        listOf(
            "https://officedesigner.com/wp-content/uploads/2023/03/office-designer-london.jpeg",
            "https://officeinteriordesign.com/wp-content/uploads/2022/08/Your-smartest-investment-1.jpg",
            "https://penkethgroup.com/wp-content/uploads/2022/10/1-29.jpg"
        ),
        "29.99",
        "4.9",
        "8",
        "24",
        "323"
    )

    private val listing2 = Property(
        "2",
        "Cleo Heights",
        "New York",
        "This is description, the property poster is supposed to write something here and fill this nigga up",
        listOf(
            "https://officedesigner.com/wp-content/uploads/2023/03/office-designer-london.jpeg",
            "https://officeinteriordesign.com/wp-content/uploads/2022/08/Your-smartest-investment-1.jpg",
            "https://penkethgroup.com/wp-content/uploads/2022/10/1-29.jpg"
        ),
        "29.99",
        "4.9",
        "8",
        "24",
        "323"
    )

    private val listing3 = Property(
        "3",
        "Cleo Heights",
        "New York",
        "This is description, the property poster is supposed to write something here and fill this nigga up",
        listOf(
            "https://officedesigner.com/wp-content/uploads/2023/03/office-designer-london.jpeg",
            "https://officeinteriordesign.com/wp-content/uploads/2022/08/Your-smartest-investment-1.jpg",
            "https://penkethgroup.com/wp-content/uploads/2022/10/1-29.jpg"
        ),
        "29.99",
        "4.9",
        "8",
        "24",
        "323"
    )

    private val listing4 = Property(
        "4",
        "Cleo Heights",
        "New York",
        "This is description, the property poster is supposed to write something here and fill this nigga up",
        listOf(
            "https://officedesigner.com/wp-content/uploads/2023/03/office-designer-london.jpeg",
            "https://officeinteriordesign.com/wp-content/uploads/2022/08/Your-smartest-investment-1.jpg",
            "https://penkethgroup.com/wp-content/uploads/2022/10/1-29.jpg"
        ),
        "29.99",
        "4.9",
        "8",
        "24",
        "323"
    )

    private val listing5 = Property(
        "5",
        "Cleo Heights",
        "New York",
        "This is description, the property poster is supposed to write something here and fill this nigga up",
        listOf(
            "https://officedesigner.com/wp-content/uploads/2023/03/office-designer-london.jpeg",
            "https://officeinteriordesign.com/wp-content/uploads/2022/08/Your-smartest-investment-1.jpg",
            "https://penkethgroup.com/wp-content/uploads/2022/10/1-29.jpg"
        ),
        "29.99",
        "4.9",
        "8",
        "24",
        "323"
    )

    private val listing6 = Property(
        "6",
        "Cleo Heights",
        "New York",
        "This is description, the property poster is supposed to write something here and fill this nigga up",
        listOf(
            "https://officedesigner.com/wp-content/uploads/2023/03/office-designer-london.jpeg",
            "https://officeinteriordesign.com/wp-content/uploads/2022/08/Your-smartest-investment-1.jpg",
            "https://penkethgroup.com/wp-content/uploads/2022/10/1-29.jpg"
        ),
        "29.99",
        "4.9",
        "8",
        "24",
        "323"
    )

    private val properties = listOf(listing1, listing2, listing3, listing4, listing5, listing6)


    fun getAllProperties(): List<Property> {
        return properties
    }

    fun getPropertyById(id:String): Property? {
        return properties.find { it.id == id }
    }


}