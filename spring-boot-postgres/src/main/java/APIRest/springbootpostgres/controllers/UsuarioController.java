package APIRest.springbootpostgres.controllers;



@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioComptoller {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/add")
    public String add(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario);
        return "Novo usuário cadastrado";
    }
    @GetMapping("/getAll")
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> get(@PathVariable Integer id){
        try{
            Usuario usuario=usuarioService.get(id);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario, @PathVariable Integer id){
        try{
            Usuario existeUsuario=usuarioService.get(id);
            usuarioService.salvarUsuario(usuario);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        usuarioService.delete(id);
        return "Usuário com id=" +id +", deletado";
    }
}
