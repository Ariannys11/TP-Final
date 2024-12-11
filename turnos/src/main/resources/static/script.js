fetch('www.themealdb.com/api/json/v1/1/categories.php')
  .then(response => response.json())
  .then(data => {
    console.log(data);  // Aquí puedes manejar los datos obtenidos de la API
  })
  .catch(error => {
    console.error('Error al obtener recetas:', error);
  });
