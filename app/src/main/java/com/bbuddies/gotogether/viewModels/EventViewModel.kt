package com.bbuddies.gotogether.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bbuddies.gotogether.R
import com.bbuddies.gotogether.entitys.EventInfo
import com.bbuddies.gotogether.entitys.User

class EventViewModel():ViewModel() {
     val listEventInfo =MutableLiveData(mutableListOf( EventInfo("Concert LinkinPark","14.09.2024","18:00","Ukraine,Kiev,VDH","rock,concert",
        User("Max T.",24, R.drawable.ic_launcher_background)),
         EventInfo("Concert LinkinPark","14.09.2024","18:00","Ukraine,Kiev,VDH","rock,concert",
             User("Max T.",24, R.drawable.ic_launcher_background)
         ),EventInfo("Concert LinkinPark","14.09.2024","18:00","Ukraine,Kiev,VDH","rock,concert",
             User("Max T.",24, R.drawable.ic_launcher_background)
         )
     ))
     fun  updateEventList(event:EventInfo){
         listEventInfo.value?.add(event)
     }
}