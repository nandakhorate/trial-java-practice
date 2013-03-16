
	function CallBuilding() {  
		  // get the form values  
		  var siteId = $('#siteId').val();
		  //var education = $('#education').val();
		  
		  $.ajax({  
		    type: "POST",  
		    url: contexPath + "/flat/CallBuilding",  
		    data: "siteId=" + siteId,  
		    success: function(response){
		      // we have the response 
		      if(response.status == "SUCCESS"){
		    	  
		    	  
		    		  userInfo = response.result;
		    	  $('#info').html(userInfo);
		    	  /*$('#name').val('');
			      $('#education').val('');
			      $('#error').hide('slow');
			      $('#info').show('slow');*/
		      }else{
		    	  alert("error");
		    	  errorInfo = "my error";
		    	 /*  for(i =0 ; i < response.result.length ; i++){
		    		  errorInfo += "<br>" + (i + 1) +". " + response.result[i].code;
		    	  } */
		    	  $('#error').html("Please correct following errors: " + errorInfo);
		    	  $('#info').hide('slow');
		    	  $('#error').show('slow');
		      }	      
		    },  
		    error: function(e){
		    	 alert("final erorr");
		      alert('Error: ' + e);  
		    }  
		  });  
		}  