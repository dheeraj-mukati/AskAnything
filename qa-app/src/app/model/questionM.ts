export class QuestionM {

  public id: Number,
  public question: String,
  public description: String,
  public category: Number,
  public userId: Number,
  public createDt: Date
  public questionMetadata: QuestionMetaDataM,
  public comments: CommentM
}
