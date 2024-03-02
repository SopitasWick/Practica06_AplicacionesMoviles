package mx.edu.itson.practica06

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class Catalogo : AppCompatActivity() {
    var adapter: PeliculaAdapter? = null
    var seriesAdapter: PeliculaAdapter?=null
    var peliculas=ArrayList<Pelicula>()
    var series=ArrayList<Pelicula>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        cargarPeliculas()
        cargarSeries()

        adapter=PeliculaAdapter(this,peliculas)
        seriesAdapter=PeliculaAdapter(this,series)
        var gridPelis:GridView = findViewById(R.id.movies_catalogo)
        var gridSeries: GridView=findViewById(R.id.mseries_catalogo)

        gridPelis.adapter=adapter
        gridSeries.adapter=seriesAdapter
    }
    fun cargarPeliculas(){
        peliculas.add(Pelicula("Demon slayer: kimetsu no yaiba - to the hashira trainnig",R.drawable.demon,R.drawable.demo,"Tanjiro emprende un viaje arriesgado para buscar una cura a la maldición de su hermana y vengar a su familia asesinada por un demonio"))
        peliculas.add(Pelicula("Dune",R.drawable.dune,R.drawable.dune2,"El periplo de un héroe mítico y con una enorme carga emocional, cuenta la historia de Paul Atreides. Se trata de un joven brillante y de gran talento con un destino grandioso que no comprende todavía y que deberá viajar al planeta más peligroso del universo para asegurar el futuro de su familia y de su pueblo. "))
        peliculas.add(Pelicula("Ghostbusters apocalipsis",R.drawable.ghostbusters,R.drawable.ghostbusters,"A los doctores Venkman, Stantz y Spengler, expertos en parapsicología, no les conceden una beca de investigación que habían solicitado. Al encontrarse sin trabajo, deciden fundar la empresa \"Los Cazafantasmas\", dedicada a limpiar Nueva York de ectoplasmas. El aumento repentino de apariciones espectrales en la ciudad será el presagio de la llegada de un peligroso y poderoso demonio."))
        peliculas.add(Pelicula("Heroe por encargo",R.drawable.heroexencargo,R.drawable.heroeencargo,"En la cinta de acción y comedia Héroe por Encargo, dirigida por Pierre Morel (Matar o morir), Mason Pettits es un exmiembro de las Fuerzas Especiales del Ejército de los Estados Unidos, que resultó herido después de una misión fallida para asesinar al dictador Juan Venegas. Tras ello y en la actualidad, Pettits trabaja como abogado, un trabajo que desprecia y en el que se siente atrapado y sin futuro."))
        peliculas.add(Pelicula("Madame web",R.drawable.madameweb,R.drawable.madame,"Selva amazónica de Perú, 1973. La bióloga Constance Webb (Kerry Bishé), embarazada, busca una singular araña que segrega sustancias curativas, pero es traicionada por su colega de expedición Ezekiel Sims (Tahar Rahim). Treinta años después, en 2003, la hija de Constance, Cassandra Webb (Dakota Johnson), trabaja como paramédica en Manhattan hasta que un día comienza a tener habilidades clarividentes, que le permiten anticipar el futuro inmediato, siempre relacionado con sucesos de su pasado en el vientre de su madre."))
        peliculas.add(Pelicula("Vidas prestadas",R.drawable.vidaspasadas,R.drawable.vidaspasadas1,"Las 8.000 capas del in-yun remiten a una sucesión de eventos del destino que van perfeccionando un vínculo hasta alcanzar la relación de amor ideal. El proceso se da durante el transcurso de varias vidas y es concepción de providencia que remite a la reencarnación en la tradición budista."))
    }
    fun cargarSeries(){
        series.add(Pelicula("Avatar la leyenda de Aang",R.drawable.ant,R.drawable.ant,"La Leyenda de Aang tiene lugar en un mundo de fantasía que es el hogar de los seres humanos, animales fantásticos y espíritus."))
        series.add(Pelicula("Halo",R.drawable.halo,R.drawable.halos,"Halo seguirá un conflicto épico en el siglo 26 entre la humanidad y una amenaza alienígena conocida como el Covenant."))
        series.add(Pelicula("Leveling",R.drawable.sololeveling,R.drawable.sololevelings," En un mundo en el que ciertos humanos llamados «cazadores» poseen habilidades mágicas, estos deben luchar contra monstruos para proteger a la raza humana de una aniquilación."))
        series.add(Pelicula("Mi adorable demonio",R.drawable.adorabledemonio,R.drawable.adorabledemonios,"Do Do-hee es la heredera chaebol de Mirae Group; es una joven arrogante, desconfiada y cínica en el amor, y tiene enemigos por todos lados. Para cumplir con una condición puesta para acceder a la herencia, Do-hee celebra un matrimonio por contrato con Jung Goo-won, un demonio que desprecia a los humanos y que lleva doscientos años en este mundo haciendo tratos peligrosos con ellos. Pero tras conocer a Do-hee pierde sus poderes de la noche a la mañana, y para evitar su propia muerte debe protegerla."))
        series.add(Pelicula("El monstruo de la vieja seul",R.drawable.elmonstruo,R.drawable.elmonstruovieja,"Este dúo dinámico comprendido entre Jang Tae-sang y Yoon Chae-ok, tendrán que unirse para lidiar con el monstruo mientras llevan a cabo sus respectivas búsquedas, y… qué mejor momento para formar una conexión potencialmente romántica. ¿A quién no le gusta un romance teniendo un monstruo de por medio?"))
        series.add(Pelicula("Witcher",R.drawable.thewitcher,R.drawable.thewitchers,"Geralt de Rivia es un brujo, mutado durante su infancia para ser más efectivo en su labor, matar monstruos por dinero. El continente se encuentra en un estado de caos debido a las ansias del Imperio de Nilfgaard por ampliar su territorio. "))
    }

}
class PeliculaAdapter:BaseAdapter{
var peliculas = ArrayList<Pelicula>()
    var context: Context? = null

    constructor(context: Context,peliculas: ArrayList<Pelicula>): super(){
        this.peliculas=peliculas
        this.context=context
    }

    override fun getCount(): Int {
        return peliculas.size
    }

    override fun getItem(p0: Int): Any {
        return peliculas[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(pe: Int, p1: View?, p2: ViewGroup?): View {
        var pelicula=peliculas[pe]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
        var vista = inflator.inflate(R.layout.pelicula,null)
        var image: ImageView=vista.findViewById(R.id.image_movie_cell)
        var title:TextView=vista.findViewById(R.id.movie_title_cell)

        image.setImageResource(pelicula.image)
        title.setText(pelicula.titulo)

        image.setOnClickListener(){
            val intento = Intent(context,detalle_pelicula::class.java)
            intento.putExtra("titulo",pelicula.titulo)
            intento.putExtra("imagen",pelicula.image)
            intento.putExtra("header",pelicula.header)
            intento.putExtra("sinopsis",pelicula.sinopsis)
           context!!.startActivity(intento)
        }
        return vista
    }
}