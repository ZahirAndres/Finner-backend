package mx.utng.finer_back_end.Alumnos.Dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import mx.utng.finer_back_end.Documentos.CursoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface CursoAlumnoDao extends JpaRepository<CursoDocumento, Long> {
    
    @Query(value = "SELECT * FROM obtener_detalles_curso_alumno(:p_id_curso)", nativeQuery = true)
    List<Object[]> verCursoDetalles(@Param("p_id_curso") Integer p_id_curso);


    @Query(value = "SELECT validar_reinscripcion(:p_id_curso, :p_id_usuario)", nativeQuery = true)
    Boolean validarReinscripcionAlumno(@Param("p_id_curso") Integer p_id_curso, @Param("p_id_usuario") Integer p_id_usuario);

    
    @Query(value = "SELECT inscribir_alumno(:p_id_curso, :p_id_usuario)", nativeQuery = true)
    Boolean inscribirseCursoAlumno(@Param("p_id_curso") Integer p_id_curso, @Param("p_id_usuario") Integer p_id_usuario);


}
