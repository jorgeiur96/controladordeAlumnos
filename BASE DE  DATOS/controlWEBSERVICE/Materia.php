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
         
        $sql = "SELECT * FROM profesormateria,materia WHERE profesormateria.CedulaPro=$cedula and materia.CodigoMateria=profesormateria.CodigoMa";
       
       
        if(!$result = mysqli_query($conexion, $sql)) die();

        $rawdata = array();
        
        
        while($row = mysqli_fetch_object($result))
        {   
            
            $rawdata[] = $row;
            
        }
      
      $rawdata;

echo json_encode($rawdata);   


?>