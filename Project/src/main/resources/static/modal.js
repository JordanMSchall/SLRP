function mapModal(modalId) {
	var modal = document.getElementById(modalId);
	var btn = document.getElementById(modalId + "_button");
	var closeButton = document.getElementById(modalId + "_close_button");

	// When the user clicks on the button, open the modal
	btn.onclick = function() {
		modal.style.display = "block";
	}

	closeButton.onclick = function() {
		modal.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
}
