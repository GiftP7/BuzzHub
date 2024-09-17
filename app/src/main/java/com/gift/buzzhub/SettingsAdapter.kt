package com.gift.buzzhub

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SettingsAdapter(
    var settingsList: ArrayList<String>,
    val context: Context
    ) : RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder>() {

    class SettingsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textSettings : TextView = itemView.findViewById(R.id.accountText)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.settings_design, parent, false)

        return SettingsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return settingsList.size
    }

    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {
        holder.textSettings.text = settingsList[position]

        holder.itemView.setOnClickListener {
            val intent = when (position) {
                0 -> Intent(context, AccountPage::class.java)
                1 -> Intent(context, NotificationPage::class.java)
                2 -> Intent(context, PaymentMethodsPage::class.java)
                3 -> Intent(context, DisplayPage::class.java)
                4 -> Intent(context, HelpCentrePage::class.java)
                5 -> {
                    val googlePrivacyPolicyUrl = "https://www.google.com/policies/privacy/"
                    Intent(Intent.ACTION_VIEW, Uri.parse(googlePrivacyPolicyUrl))
                }
                6 -> Intent(context, DeleteAccountPage::class.java)
                else -> null
            }
            intent?.let { context.startActivity(it) }
        }

    }

}