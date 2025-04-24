<?php
require_once("sql/createDB.php");
session_start();

$targetUserId = $_SESSION['idLogin'];
$currentPassword = $_SESSION['password'];

if (isset($_POST['submit'])) {
    
    $emailUpdate = $_POST['email'];
    $postPassword = $_POST['password'];
    $passwordUpdate = $_POST['newPassword'];
    $cNumberUpdate = $_POST['cNumber'];

    if ($currentPassword == $postPassword) {

        $file_name = $_FILES['image']['name'];
        $tempname = $_FILES['image']['tmp_name'];

        if (!empty($file_name)) {
            $file_ext = pathinfo($file_name, PATHINFO_EXTENSION);
            $base_name = pathinfo($file_name, PATHINFO_FILENAME);
            $sanitized_name = preg_replace('/[^A-Za-z0-9_\-]/', '_', $base_name);
            $new_file_name = "uploaded_images/" . $sanitized_name . ".png";

            if (move_uploaded_file($tempname, $new_file_name)) {
                $img_query = "UPDATE users SET profilePicture = '$new_file_name' WHERE userId = '$targetUserId' LIMIT 1";

                if (!mysqli_query($conn, $img_query)) {
                    die("Error updating profile picture: " . mysqli_error($conn));
                }

                $_SESSION['profilePic'] = $new_file_name;
            } else {
                die("Error uploading the file.");
            }
        }

        $query = "UPDATE users SET email = '$emailUpdate', password = '$passwordUpdate', cNumber = '$cNumberUpdate' WHERE userId = '$targetUserId' LIMIT 1";

        if (mysqli_query($conn, $query)) {
            $_SESSION['emailLogin'] = $emailUpdate;
            $_SESSION['cNumber'] = $cNumberUpdate;
            $_SESSION['password'] = $passwordUpdate;

            header("Location: profile.php");
            exit();
        } else {
            die("Error updating user information: " . mysqli_error($conn));
        }
    } else {
        header("Location: edit_profile.php?error=Incorrect password");
        exit();
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./output.css">
</head>
<body>
    <div class="absolute z-50 mt-10 ml-10">
        <a href="profile.php" class="mb-12 text-white">&#8249;&nbsp;Back to profile</a>
    </div>
    <div class="bg-gradient-to-tl from-secondary-100 to-primary-100 w-full h-[50vh] absolute z-0">
        <div class="w-full h-[120vh] flex flex-row justify-center items-center">
            <form method="POST" enctype="multipart/form-data">
                <div class="bg-white shadow-md sm:w-[50vw] w-[70vw] sm:h-[80vh] rounded-md z-10 mt-[20vh] flex flex-col items-center">
                    <div class="w-[15vh] h-[15vh] sm:w-[25vh] sm:h-[25vh] translate-y-[-6vh] sm:translate-y-[-10vh] shadow-md rounded-md">
                        <img src="<?php echo $_SESSION['profilePic'] ?>" class="w-full h-full rounded-md border-white border-4" alt="profile picture" id="output">
                        <input type="file" accept="image/*" name="image" onchange="loadFile(event)" class="w-[20vw] mt-2">
                    </div>
                    <div class="flex flex-col items-center translate-y-[-5vh]">
                        <div>
                            <p class="p-2 sm:text-4xl text-xl font-semibold text-primary-100"><?php echo $_SESSION['fullName']?></p>
                        </div>
                        <div>
                            <label for="email" class="font-bold text-md mb-1">Email: </label><br>
                            <input autocomplete="off" required name="email" type="text" value="<?php echo $_SESSION['emailLogin'] ?>" class="box-border text-txtgray-100 border-[0.5px] border-txtgray-100 outline-none p-1 rounded-[3px] w-20vw mb-2">
                        </div>
                        <div>
                            <label for="password" class="font-bold text-md mb-1">Password: </label><br>
                            <input autocomplete="off" required name="password" type="password" placeholder="Old Password" class="box-border text-txtgray-100 border-[0.5px] border-txtgray-100 outline-none p-1 rounded-[3px] w-20vw mb-2">
                        </div>
                        <div>
                            <label for="newPassword" class="font-bold text-md mb-1">New Password: </label><br>
                            <input autocomplete="off" required name="newPassword" type="password" placeholder="New Password" class="box-border text-txtgray-100 border-[0.5px] border-txtgray-100 outline-none p-1 rounded-[3px] w-20vw mb-2">
                        </div>
                        <div>
                            <label for="cNumber" class="font-bold text-md mb-1">Contact Number: </label><br>
                            <input autocomplete="off" required name="cNumber" type="text" value="<?php echo $_SESSION['cNumber'] ?>" class="box-border text-txtgray-100 border-[0.5px] border-txtgray-100 outline-none p-1 rounded-[3px] w-20vw mb-2">
                        </div>
                        <div class="text-center">
                            <button type="submit" name="submit" class="p-2 bg-gradient-to-tl from-secondary-100 to-primary-100 w-[30vw] sm:w-[10vw] rounded-sm text-white font-semibold mt-2">Submit</button>
                            <br><p class="error">
                            <?php
                                if(isset($_GET['error'])){ ?>
                                    <p class="error text-redbutton-100 font-semibold">Incorrect password. Please try again.</p>
                            <?php } ?>
                            </p>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script>
        var loadFile = function(event) {
          var output = document.getElementById('output');
          output.src = URL.createObjectURL(event.target.files[0]);
          output.onload = function() {
            URL.revokeObjectURL(output.src)
          }
        };
      </script>
</body>
</html>