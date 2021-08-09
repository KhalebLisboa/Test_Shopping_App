import com.example.test_shopping_app.data.SaleService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val interceptor =
    OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .apply { this.level = HttpLoggingInterceptor.Level.BODY })
        .build()


val retrofit = Retrofit.Builder()
    .baseUrl("http://www.mocky.io/v2/")
    .client(interceptor)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
