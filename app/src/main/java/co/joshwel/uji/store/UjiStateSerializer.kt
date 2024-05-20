package co.joshwel.uji.store

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream


object UjiStateSerializer : Serializer<UjiState> {
    override val defaultValue: UjiState = UjiState.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UjiState {
        try {
            return UjiState.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: UjiState, output: OutputStream) = t.writeTo(output)
}

val Context.dataStore: DataStore<UjiState> by dataStore(
    fileName = "uji_state.pb", serializer = UjiStateSerializer
)
