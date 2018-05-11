<?php 
        
            $server = "localhost";
            $usuario = "root";
            $pass = "";
            $BD = "controldealumnos";
            
            $conexion = mysqli_connect($server, $usuario, $pass, $BD); 
            
            if(!$conexion){ 
               echo 'Ha sucedido un error inexperado en la conexion de la base de datos<br>'; 
            } 
           $cedula=$_REQUEST["cedula"];
         
        $sql = "SELECT grupo.GradoGrupo FROM profesorgrupo,profesor,grupo WHERE profesorgrupo.ced_pro=$cedula AND profesor.CedulaProfesor=profesorgrupo.ced_pro AND grupo.cod_grupo=profesorgrupo.cod_gru ";
       
       
        if(!$result = mysqli_query($conexion, $sql)) die();

        $rawdata = array();
        
        
        while($row = mysqli_fetch_object($result))
        {   
            
            $rawdata[] = $row;
            
        }
      
      $rawdata;

echo json_encode($rawdata);   


?>