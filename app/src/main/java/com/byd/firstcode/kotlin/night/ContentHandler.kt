package com.byd.firstcode.kotlin.night

import android.util.Log
import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler
import java.lang.StringBuilder

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/08
 * desc :
 * version: 1.0
 * </pre>
 */
class ContentHandler : DefaultHandler() {

    private var nodeName = ""
    private lateinit var id: StringBuilder
    private lateinit var name: StringBuilder
    private lateinit var version: StringBuilder

    override fun startDocument() {
        super.startDocument()
        id = StringBuilder()
        name = StringBuilder()
        version = StringBuilder()
    }

    override fun startElement(
        uri: String?,
        localName: String?,
        qName: String?,
        attributes: Attributes?
    ) {
        super.startElement(uri, localName, qName, attributes)
        nodeName = localName ?: "";
        Log.d("ContentHandler", "uri is $uri");
        Log.d("ContentHandler", "localName is $localName");
        Log.d("ContentHandler", "qName is $qName");
        Log.d("ContentHandler", "attributes is $attributes");
    }

    override fun characters(ch: CharArray?, start: Int, length: Int) {
        super.characters(ch, start, length)
        when (nodeName) {
            "id" -> id.append(ch, start, length)
            "name" -> name.append(ch, start, length)
            "version" -> version.append(ch, start, length)
        }

    }

    override fun endElement(uri: String?, localName: String?, qName: String?) {
        super.endElement(uri, localName, qName)
        if ("app" == localName) {
            Log.d("ContentHandler", "id is ${id.toString().trim()}");
            Log.d("ContentHandler", "name is ${name.toString().trim()}");
            Log.d("ContentHandler", "version is ${version.toString().trim()}}");
            id.setLength(0)
            name.setLength(0)
            version.setLength(0)
        }
    }

    override fun endDocument() {
        super.endDocument()
    }

}