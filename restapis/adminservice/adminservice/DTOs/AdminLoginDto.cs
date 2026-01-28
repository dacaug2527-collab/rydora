namespace adminservice.DTOs
{
    public class AdminLoginDto
    {
        public string email { get; set; }
        public string password { get; set; }

        public int roleId {  get; set; } = 1;

        
    }
}
