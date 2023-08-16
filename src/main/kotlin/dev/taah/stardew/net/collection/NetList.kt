package dev.taah.stardew.net.collection

import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject
import dev.taah.stardew.util.serialization.NetObjectSerializers

/**
 * @author Taah
 * @project stardew-server
 * @since 1:56 PM [16-08-2023]
 */
// Set writeDoubleCount to false if writing a NetArray
class NetList<T>(val writeDoubleCount: Boolean = true) : INetObject, MutableList<T> {
    val list: MutableList<T> = mutableListOf()
    override fun serialize(buffer: PacketBuffer) {
        if (writeDoubleCount) {
            buffer.writeIntLE(list.size)
        }
        buffer.writeCollection(list) { t, u ->
            NetObjectSerializers.getSerializer(u!!.javaClass)?.accept(t!!, u)
        }
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }

    override val size: Int
        get() = list.size

    override fun clear() {
        list.clear()
    }

    override fun addAll(elements: Collection<T>): Boolean {
        return list.addAll(elements)
    }

    override fun addAll(index: Int, elements: Collection<T>): Boolean {
        return list.addAll(index, elements)
    }

    override fun add(index: Int, element: T) {
        return list.add(index, element)
    }

    override fun add(element: T): Boolean {
        return list.add(element)
    }

    override fun get(index: Int): T {
        return list[index]
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun iterator(): MutableIterator<T> {
        return list.iterator()
    }

    override fun listIterator(): MutableListIterator<T> {
        return list.listIterator()
    }

    override fun listIterator(index: Int): MutableListIterator<T> {
        return list.listIterator(index)
    }

    override fun removeAt(index: Int): T {
        return list.removeAt(index)
    }

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<T> {
        return list.subList(fromIndex, toIndex)
    }

    override fun set(index: Int, element: T): T {
        return list.set(index, element)
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        return list.retainAll(elements)
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        return list.removeAll(elements)
    }

    override fun remove(element: T): Boolean {
        return list.remove(element)
    }

    override fun lastIndexOf(element: T): Int {
        return list.lastIndexOf(element)
    }

    override fun indexOf(element: T): Int {
        return list.indexOf(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return list.containsAll(elements)
    }

    override fun contains(element: T): Boolean {
        return list.contains(element)
    }
}