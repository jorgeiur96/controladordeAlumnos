<?php 
        
            $server = "localhost";
            $usuario = "root";
            $pass = "";
            $BD = "controldealumnos";
            
            $conexion = mysqli_connect($server, $usuario, $pass, $BD); 
            
            if(!$conexion){ 
               echo 'Ha sucedido un error inexperado en la conexion de la base de datos<br>'; 
            } 
            $correo=$_REQUEST["correo"];
         
        $sql = "SELECT * FROM profesor where correo=$correo";
       
       
        if(!$result = mysqli_query($conexion, $sql)) die();

        $rawdata = array();
        
        
        while($row = mysqli_fetch_object($result))
        {   
            
            $rawdata[] = $row;
            
        }
      
      $rawdata;

echo json_encode($rawdata);   


?>