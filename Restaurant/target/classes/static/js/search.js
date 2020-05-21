function searchFunction() {
	let filter = document.getElementById("myinput").value.toUpperCase();
	let r = document.getElementsByClassName("col-sm-3");
	let row = document.getElementsByClassName("card-title");

	for (var i = 0; i < row.length; i++) {
		let movie = row[i].textContent;
		if (movie.toUpperCase().indexOf(filter) > -1) {
			r[i].style.display = "";
		} else {
			r[i].style.display = "none";
		}
	}

}