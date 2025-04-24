<?php
    use PHPMailer\PHPMailer\PHPMailer;
    use PHPMailer\PHPMailer\Exception;

    require 'vendor/autoload.php';
    session_start();
    $mail = new PHPMailer(true);

    $otpCode = $_SESSION['otp'];
    $subject = "VetSystem Account Verification";
    $message = "<h3>VETSYSTEM verification link<h3>
                <p><b>Please click the link attached in this email to verify your account</b></p>
                <br><br>
                <a style='color:green; text-decoration:none; font-weight:600;' href='localhost/vetsystem/code/verify_email.php?tokencode=$otpCode'>Verify Email</a>";
    $email = $_SESSION['email'];

    try {
        $mail->isSMTP();
        $mail->Host = 'smtp-relay.brevo.com';
        $mail->SMTPAuth = true;
        $mail->Username = 'bagisanjudel@gmail.com';
        $mail->Password = 'jhEIqFS6gPKywHL9';
        $mail->SMTPSecure = 'tls';
        $mail->Port = 587;

        $mail->setFrom('bagisanjudel@gmail.com', 'Veterinary System');
        $mail->addAddress($email);
        // $mail->addAddress('recipient2@example.com', 'Name');

        $mail->isHTML(true);
        $mail->Subject = $subject;
        $mail->Body = $message;
        $mail->AltBody = $message;
        $mail->send();
        header("Location: success_email.php");
    } catch(Exception $e) {
        echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
    }
?>  