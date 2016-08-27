$(function(){

	$("#salvar").click(function(event){
		$("#taskForm").submit();
		 event.preventDefault();
	});
	
	$("#borrar").click(function(event){
		$("#borrarForm").submit();
		 event.preventDefault();
	});

	$("#nombre").blur(validateName)
	          .keyup(validateName);
	
	$("#nameControl button").click(validateName);
	
    $("#taskForm").submit(validateName);
    
    // Errror popup
    var errorContent = $('#errorContent').html();
    if (errorContent) {
        $.Dialog({
            overlay: true,
            shadow: true,
            flat: true,
            icon: '<span class="icon-blocked fg-red"></span>',
            title: '<span class="fg-red">Error</span>',
            content: errorContent,
            padding: 20,
            width:  300
        });
    }
    
    function validateName() {
    	var result;
    	if ($("#nombre").val() < 1) {
    		$("#nameControl").addClass("error-state");
    		$("#nameMessage").text("(Required)");
    		result = false;
    	} else {
    		$("#nameControl").removeClass("error-state");
    		$("#nameMessage").text("");
    		result = true;
    	}
    	return result;		
    }
	
});