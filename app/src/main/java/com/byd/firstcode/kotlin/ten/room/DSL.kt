package com.byd.firstcode.kotlin.ten.room

import android.util.Log
import android.widget.Toast

class Td {
    var content = ""
    fun html() = "\n\t\t<td>$content</td>"
}

class Tr {
    private val children = ArrayList<Td>()
    fun td(block: Td.() -> String) {
        val td = Td()
        td.content = td.block()
        children.add(td)
    }
    fun html():String{
        val builder = StringBuilder()
        builder.append("\n\t<tr>")
        for(childTag in children){
            builder.append(childTag.html())
        }
        builder.append("\n\t</tr>")
        return builder.toString()
    }
}

class Table{
    private val children = ArrayList<Tr>()
    fun tr(block: Tr.() -> Unit){
        val tr = Tr()
        tr.block()
        children.add(tr)
    }
    fun html():String{
        val builder = StringBuilder()
        builder.append("<table>")
        for(childTag in children){
            builder.append(childTag.html())
        }
        builder.append("\n</table>")
        return builder.toString()
    }
}
fun table(block: Table.() -> Unit):String{
    val table = Table()
    table.block()
    return table.html()

}



fun String.showToast(duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(MyApplication.context, this, duration).show()
}
fun Int.showToast(duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(MyApplication.context, this, duration).show()
}

class Dependency {
    val libraries = ArrayList<String>()
    fun implementation(lib: String) {
        libraries.add(lib)
    }
}

fun dependencies(block: Dependency.() -> Unit): List<String> {
    val dependency = Dependency()
    dependency.block()
    return dependency.libraries
}