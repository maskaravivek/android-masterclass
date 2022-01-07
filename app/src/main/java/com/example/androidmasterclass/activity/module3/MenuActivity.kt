package com.example.androidmasterclass.activity.module3

import android.os.Bundle
import android.view.*
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import com.example.androidmasterclass.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        displayMenuBasedOnAction()
    }

    private fun displayMenuBasedOnAction() {
        val extras = intent.extras
        if (extras == null) {
            return
        }
        val action = extras?.getString("action")
        var imageButton = findViewById(R.id.image_button) as ImageButton
        if (action.equals("popupMenu")) {
            imageButton.visibility = View.VISIBLE
        } else {
            imageButton.visibility = View.GONE
        }

        var imageButtonForContextMenu =
            findViewById(R.id.image_button_for_context_menu) as ImageButton
        if (action.equals("contextMenu")) {
            imageButtonForContextMenu.visibility = View.VISIBLE
            registerContextMenu()
        } else {
            imageButtonForContextMenu.visibility = View.GONE
        }
    }

    private fun registerContextMenu() {
        var imageButtonForContextMenu =
            findViewById(R.id.image_button_for_context_menu) as ImageButton
        registerForContextMenu(imageButtonForContextMenu)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.setHeaderTitle("Choose an item")
        menu?.add(0, v!!.id, 0, "green")
        menu?.add(0, v!!.id, 0, "blue")
        menu?.add(0, v!!.id, 0, "red")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.title.equals("green")) {
            showAlert("Context Menu", "Green clicked!")
        } else if (item.title.equals("blue")) {
            showAlert("Context Menu", "Blue clicked!")
        } else {
            showAlert("Context Menu", "Red clicked!")
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_options_menu, menu)
        return true
    }

    fun showPopup(v: View) {
        val popup = PopupMenu(this, v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.menu_options_menu, popup.menu)
        popup.setOnMenuItemClickListener {
            showAlert(it.getTitle().toString(), it.getTitle().toString() + " clicked!")
            true;
        }
        popup.show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.new_game -> {
                showAlert("New game", "New game clicked!")
                true
            }
            R.id.help -> {
                showAlert("Help", "Help clicked!")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showAlert(title: String, message: String) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .show()
    }
}